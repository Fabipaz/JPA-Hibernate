package br.com.alura.tienda.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Producto;
import col.com.alura.dao.CategoriaDao;
import col.com.alura.dao.ProductoDao;
import col.com.alura.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria ("CELULARES");
		//Producto celular = new Producto("Samsung","telefono usado",
				//new BigDecimal("1000"), celulares);

		

	    EntityManager em = JPAUtils.getEntityManager();
	    
	    //ProductoDao productoDao = new ProductoDao(em);
	    //CategoriaDao categoriaDao = new CategoriaDao(em);
	    
	    em.getTransaction().begin();
	    em.persist(celulares);
	    
	    celulares.setNombre("LIBROS");
	    
	    //categoriaDao.guardar(celulares);
	    //productoDao.guardar(celular);
	    
	    //em.getTransaction().commit();
	    //em.close();
	    
	    em.flush();
	    em.clear();
	    
	    celulares = em.merge(celulares);
	    celulares.setNombre("SOTFWARES");
	    
	    em.flush();
	    em.clear();
	    
	    celulares = em.merge(celulares);
	    em.remove(celulares);
	    em.flush();
	}

}
