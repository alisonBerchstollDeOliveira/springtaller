package py.edu.facitec.springtaller.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import py.edu.facitec.springtaller.general.General;
@Entity
public class Pedido extends General{

	private Date fechaToma;
	
	private Date fechaEntrega;
	
	private double total;
	//Indicamos que se trata de una relacion de muchos para uno
	//posibilita la creacion de la clave foranea
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Usuario usuario;
	
	@JsonIdentityReference
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;

	

	public Date getFechaToma() {
		return fechaToma;
	}

	public void setFechaToma(Date fechaToma) {
		this.fechaToma = fechaToma;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	@Override
	public String toString() {
		return "Pedido [fechaToma=" + fechaToma + ", fechaEntrega=" + fechaEntrega + ", total=" + total
				+ ", cliente=" + cliente + ", usuario=" + usuario + ", itemPedidos=" + itemPedidos + "]";
	}
	
	
	
	
}
