package br.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Producto;
import col.com.alura.dao.ProductoDao;
import col.com.alura.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular = new Producto("Samsung","telefono usado",
				new BigDecimal("1000"), Categoria.CELULARES);

		

	    EntityManager em = JPAUtils.getEntityManager();
	    
	    ProductoDao productoDao = new ProductoDao(em);
	    
	    em.getTransaction().begin();
	    productoDao.guardar(celular);
	    em.getTransaction().commit();
	    em.close();
	}

}
