package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Producto;
@Repository //Manipulara los datos
public class ProductoDAO extends DAOGenerico<Producto>{
	//Contexto de persistencia // Manipulador de entidad
	@PersistenceContext 
	private EntityManager em;
	
	public ProductoDAO() {
		super(Producto.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
