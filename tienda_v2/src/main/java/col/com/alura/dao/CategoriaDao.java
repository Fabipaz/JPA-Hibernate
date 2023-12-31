package col.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.tienda.modelo.Categoria;

public class CategoriaDao {
	private EntityManager em;
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void actualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remove(Categoria categoria) {
		categoria=this.em.merge(categoria);
		this.em.remove(categoria);
	}
}
