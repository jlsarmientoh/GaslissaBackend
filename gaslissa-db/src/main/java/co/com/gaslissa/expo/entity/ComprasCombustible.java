package co.com.gaslissa.expo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the COMPRAS_COMBUSTIBLE database table.
 * 
 */
@Entity
@Table(name="COMPRAS_COMBUSTIBLE")
@NamedQuery(name="ComprasCombustible.findAll", query="SELECT c FROM ComprasCombustible c")
public class ComprasCombustible {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_COMPRA")
	private long idCompra;
	
	@Column(name="FACTURA")
	private long factura;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;
	
	@Column(name="CANTIDAD_GL")
	private double	cantidad;
	
	@Column(name="VALOR_UNITARIO")
	private double valorUnitario;
	
	@Column(name="VALOR")
	private double valor;
	
	@Column(name="FLETE")
	private double flete;
	
	@Column(name="SOLDICOM")
	private double soldicom;
		
	@Column(name="IMPUESTO")
	private double impuesto;
	
	@Column(name="FECHA")
	private Timestamp fecha;

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getFactura() {
		return factura;
	}

	public void setFactura(long factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getFlete() {
		return flete;
	}

	public void setFlete(double flete) {
		this.flete = flete;
	}

	public double getSoldicom() {
		return soldicom;
	}

	public void setSoldicom(double soldicom) {
		this.soldicom = soldicom;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}
