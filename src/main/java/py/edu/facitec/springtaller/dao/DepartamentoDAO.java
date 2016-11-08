package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Departamento;
@Repository
public class DepartamentoDAO extends DAOGenerico<Departamento>{
	@PersistenceContext
	private EntityManager em;
	public DepartamentoDAO() {
		super(Departamento.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
