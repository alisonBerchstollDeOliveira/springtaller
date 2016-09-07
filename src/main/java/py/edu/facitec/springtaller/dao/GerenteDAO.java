package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Gerente;
@Repository
public class GerenteDAO extends DAOGenerico<Gerente>{
	@PersistenceContext
	private EntityManager em;
	public GerenteDAO() {
		super(Gerente.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
