package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Cliente;

@Repository
//Clase encargada de la manipulacion de datos, posibilita posteriormente utilizar la anotacion Awwired
public class ClienteDAO extends DAOGenerico<Cliente>{
	@PersistenceContext
	private EntityManager em;
	
	public ClienteDAO() {
		super(Cliente.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	
	
	}
//	//Gestionar el entity manager
//	@PersistenceContext
//	private EntityManager manager;
//	
//	public void save(Cliente cliente){
//		manager.persist(cliente);
//	}
}
