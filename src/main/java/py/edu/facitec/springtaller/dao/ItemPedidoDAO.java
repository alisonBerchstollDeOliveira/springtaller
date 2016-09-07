package py.edu.facitec.springtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.springtaller.model.ItemPedido;
@Repository
public class ItemPedidoDAO extends DAOGenerico<ItemPedido>{
	@PersistenceContext
	private EntityManager em;
	public ItemPedidoDAO() {
		super(ItemPedido.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
