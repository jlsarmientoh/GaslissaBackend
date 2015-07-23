/**
 * 
 */
package co.com.gaslissa.expo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the VENTAS database table.
 * 
 */
@Entity
@Table(name="VENTAS")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta {
	
	@Id
	@Column(name="TIQUETE")
	private long tiquete;
	
	@Column(name="FECHA")
	private Timestamp fecha;
	
	@Column(name="NIT")
	private String nit;
	
	@Column(name="CLIENTE")
	private String cliente;
	
	@Column(name="PRODUCTO")
	private String producto;
	
	@Column(name="PLACA")
	private String placa;
	
	@Column(name="KILOMETRAJE")
	private double kilometraje;
	
	@Column(name="TOTAL")
	private double total;
	
	@Column(name="ISLA")
	private int isla;
	
	@Column(name="TURNO")
	private int turno;
	
	@ManyToOne
	@JoinColumn(name="MODO_PAGO")
	private ModoPago modoPago;
	
	@Column(name="FECHA_REGISTO")
	private Timestamp fechaRegistro;
	
	@Column(name="COD_EMPLEADO")
	private long codEmpleado;
	
	public Venta(){}
	
	public Venta(Timestamp fecha, String nit, double total, ModoPago modoPago) {
		super();
		this.fecha = fecha;
		this.nit = nit;
		this.total = total;
		this.modoPago = modoPago;
	}

	public Venta(String nit, double total, ModoPago modoPago) {
		super();
		this.nit = nit;
		this.total = total;
		this.modoPago = modoPago;
	}

	public Venta(String nit, double total) {
		super();
		this.nit = nit;
		this.total = total;
	}

	public long getTiquete() {
		return tiquete;
	}

	public void setTiquete(long tiquete) {
		this.tiquete = tiquete;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getIsla() {
		return isla;
	}

	public void setIsla(int isla) {
		this.isla = isla;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public ModoPago getModoPago() {
		return modoPago;
	}

	public void setModoPago(ModoPago modoPago) {
		this.modoPago = modoPago;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public long getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(long codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
}
