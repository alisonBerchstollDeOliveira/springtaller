package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Usuario;
@Repository								//Paso de la clase usuario que se convierte en objeto.
public class UsuarioDAO extends DAOGenerico<Usuario>{
	@PersistenceContext
	private EntityManager em;
	
	public UsuarioDAO() {
		//Paso de la clase Usuario al dao Generico.
		super(Usuario.class);

	}
	@Override //Sobre - escribir
	protected EntityManager getEntityManager() {

		return em;
	}
	
}
