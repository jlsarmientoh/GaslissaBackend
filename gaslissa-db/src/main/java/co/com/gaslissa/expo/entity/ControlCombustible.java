package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CONTROL_COMBUSTIBLE database table.
 * 
 */
@Entity
@Table(name="CONTROL_COMBUSTIBLE")
@NamedQuery(name="ControlCombustible.findAll", query="SELECT c FROM ControlCombustible c")
public class ControlCombustible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID")
	private long id;

	@Column(name="FECHA")
	private Timestamp fecha;

	@Column(name="GALONES_COMPRA")
	private int galonesCompra;

	@Column(name="INV_FINAL")
	private int invFinal;

	@Column(name="INV_INICIAL")
	private int invInicial;

	@Column(name="PORCENTAJE_EDS")
	private double porcentajeEds;

	@Column(name="SOBRANTE_ACUMULADO")
	private int sobranteAcumulado;

	@Column(name="SOBRANTE_DIA")
	private int sobranteDia;

	@Column(name="VENTA_MEDIDA")
	private int ventaMedida;

	@Column(name="VENTA_SURTIDOR")
	private int ventaSurtidor;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	public ControlCombustible() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getGalonesCompra() {
		return this.galonesCompra;
	}

	public void setGalonesCompra(int galonesCompra) {
		this.galonesCompra = galonesCompra;
	}

	public int getInvFinal() {
		return this.invFinal;
	}

	public void setInvFinal(int invFinal) {
		this.invFinal = invFinal;
	}

	public int getInvInicial() {
		return this.invInicial;
	}

	public void setInvInicial(int invInicial) {
		this.invInicial = invInicial;
	}

	public double getPorcentajeEds() {
		return this.porcentajeEds;
	}

	public void setPorcentajeEds(double porcentajeEds) {
		this.porcentajeEds = porcentajeEds;
	}

	public int getSobranteAcumulado() {
		return this.sobranteAcumulado;
	}

	public void setSobranteAcumulado(int sobranteAcumulado) {
		this.sobranteAcumulado = sobranteAcumulado;
	}

	public int getSobranteDia() {
		return this.sobranteDia;
	}

	public void setSobranteDia(int sobranteDia) {
		this.sobranteDia = sobranteDia;
	}

	public int getVentaMedida() {
		return this.ventaMedida;
	}

	public void setVentaMedida(int ventaMedida) {
		this.ventaMedida = ventaMedida;
	}

	public int getVentaSurtidor() {
		return this.ventaSurtidor;
	}

	public void setVentaSurtidor(int ventaSurtidor) {
		this.ventaSurtidor = ventaSurtidor;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}