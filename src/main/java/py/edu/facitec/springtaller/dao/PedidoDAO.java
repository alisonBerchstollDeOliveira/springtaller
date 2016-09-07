package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.Pedido;
@Repository
public class PedidoDAO extends DAOGenerico<Pedido>{
	@PersistenceContext
	private EntityManager em;
	public PedidoDAO() {
		super(Pedido.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
