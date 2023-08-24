package br.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.tienda.modelo.Producto;
import col.com.alura.dao.ProductoDao;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular= new Producto();
		celular.setNombre("Xiaomi Redmi");
		celular.setDescripcion("Muy Bueno");
		celular.setPrecio(new BigDecimal("800"));

		EntityManagerFactory factory = Persistence.
		        createEntityManagerFactory("tienda");

	    EntityManager em = factory.createEntityManager();
	    
	    ProductoDao productoDao = new ProductoDao(em);
	    
	    em.getTransaction().begin();
	    productoDao.guardar(celular);
	    em.getTransaction().commit();
	    em.close();
	}

}
