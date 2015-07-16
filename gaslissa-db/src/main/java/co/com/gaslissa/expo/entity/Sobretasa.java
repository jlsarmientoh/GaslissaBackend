package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SOBRETASAS database table.
 * 
 */
@Entity
@Table(name="SOBRETASAS")
@NamedQuery(name="Sobretasa.findAll", query="SELECT s FROM Sobretasa s")
public class Sobretasa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID")
	private long id;

	@Column(name="ANIO_VIGENCIA")
	private int anioVigencia;

	@Column(name="DIA_FIN_VIGENCIA")
	private int diaFinVigencia;

	@Column(name="DIA_INICIO_VIGENCIA")
	private int diaInicioVigencia;

	@Column(name="FLETES")
	private double fletes;

	@Column(name="MES_VIGENCIA")
	private int mesVigencia;

	@Column(name="PRECIO_BASE")
	private double precioBase;

	@Column(name="SOBRETASA")
	private double sobretasa;

	@Column(name="SOLDICOM")
	private double soldicom;

	@Column(name="VENTA")
	private double venta;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	public Sobretasa() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAnioVigencia() {
		return this.anioVigencia;
	}

	public void setAnioVigencia(int anioVigencia) {
		this.anioVigencia = anioVigencia;
	}

	public int getDiaFinVigencia() {
		return this.diaFinVigencia;
	}

	public void setDiaFinVigencia(int diaFinVigencia) {
		this.diaFinVigencia = diaFinVigencia;
	}

	public int getDiaInicioVigencia() {
		return this.diaInicioVigencia;
	}

	public void setDiaInicioVigencia(int diaInicioVigencia) {
		this.diaInicioVigencia = diaInicioVigencia;
	}

	public double getFletes() {
		return this.fletes;
	}

	public void setFletes(double fletes) {
		this.fletes = fletes;
	}

	public int getMesVigencia() {
		return this.mesVigencia;
	}

	public void setMesVigencia(int mesVigencia) {
		this.mesVigencia = mesVigencia;
	}

	public double getPrecioBase() {
		return this.precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public double getSobretasa() {
		return this.sobretasa;
	}

	public void setSobretasa(double sobretasa) {
		this.sobretasa = sobretasa;
	}

	public double getSoldicom() {
		return this.soldicom;
	}

	public void setSoldicom(double soldicom) {
		this.soldicom = soldicom;
	}

	public double getVenta() {
		return this.venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}