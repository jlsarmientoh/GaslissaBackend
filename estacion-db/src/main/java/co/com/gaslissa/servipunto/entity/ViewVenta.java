package co.com.gaslissa.servipunto.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the ViewVentas database table.
 * 
 */
@Entity
@Table(name="ViewVentas")
@NamedQuery(name="ViewVenta.findAll", query="SELECT v FROM ViewVenta v")
public class ViewVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CANTIDAD")
	private BigDecimal cantidad;

	@Column(name="Cliente")
	private String cliente;

	@Column(name="COD_EMP")
	private String codEmp;

	@Column(name="DESCUENTO")
	private BigDecimal descuento;

	@Column(name="FECHA")
	private Timestamp fecha;

	@Column(name="Isla")
	private int isla;

	@Column(name="KIL_ACT")
	private BigDecimal kilAct;

	@Column(name="NIT")
	private String nit;

	@Column(name="Producto")
	private String producto;

	@Id
	@Column(name="Tiquete_Nro")
	private int tiquete_Nro;

	@Column(name="TOTAL")
	private BigDecimal total;

	@Column(name="Turno")
	private short turno;

	@Column(name="Vehiculo_Placa")
	private String vehiculo_Placa;

	public ViewVenta() {
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getIsla() {
		return this.isla;
	}

	public void setIsla(int isla) {
		this.isla = isla;
	}

	public BigDecimal getKilAct() {
		return this.kilAct;
	}

	public void setKilAct(BigDecimal kilAct) {
		this.kilAct = kilAct;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getTiquete_Nro() {
		return this.tiquete_Nro;
	}

	public void setTiquete_Nro(int tiquete_Nro) {
		this.tiquete_Nro = tiquete_Nro;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public short getTurno() {
		return this.turno;
	}

	public void setTurno(short turno) {
		this.turno = turno;
	}

	public String getVehiculo_Placa() {
		return this.vehiculo_Placa;
	}

	public void setVehiculo_Placa(String vehiculo_Placa) {
		this.vehiculo_Placa = vehiculo_Placa;
	}

}