package py.edu.facitec.springtaller.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import py.edu.facitec.springtaller.general.General;
@Entity
public class Producto extends General{
	@Column(length=100,nullable=false,unique=true)
	private String descripcion;
	
	private Date fechaVencimiento;
	
	private Double precio;
	
	private Integer cantidad;
	
	@OneToMany(mappedBy="producto")
	private List<ItemPedido> itemPedidos;

	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento
				+ ", precio=" + precio + ", cantidad=" + cantidad + ", itemPedidos=" + itemPedidos + "]";
	}
	
	
}
