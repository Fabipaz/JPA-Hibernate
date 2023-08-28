package br.com.alura.tienda.tests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import br.com.alura.tienda.modelo.Categoria;
import br.com.alura.tienda.modelo.Producto;
import col.com.alura.dao.CategoriaDao;
import col.com.alura.dao.ProductoDao;
import col.com.alura.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
	    EntityManager em = JPAUtils.getEntityManager();            
	    ProductoDao productoDao = new ProductoDao(em);
	    Producto producto = productoDao.consultaPorId(1l);
	    System.out.println(producto.getNombre());
	    
	    List<Producto> productos= productoDao.consultaPorNombreDeCategoria("CELULARES");
	    productos.forEach(prod->System.out.println(prod.getDescripcion()));
	 
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria ("CELULARES");
		
		Producto celular = new Producto("Xiaomi Redmi","Muy Legal",
				new BigDecimal("800"), celulares);

		

	    EntityManager em = JPAUtils.getEntityManager();            
	    ProductoDao productoDao = new ProductoDao(em);
	    CategoriaDao categoriaDao = new CategoriaDao(em);
	    

	    em.getTransaction().begin();	   
	    categoriaDao.guardar(celulares);
	    productoDao.guardar(celular);
	    
	    em.getTransaction().commit();
	    em.close();
	}

}
