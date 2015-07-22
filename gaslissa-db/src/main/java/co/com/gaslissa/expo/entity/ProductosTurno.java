package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PRODUCTOS_TURNO database table.
 * 
 */
@Entity
@Table(name="PRODUCTOS_TURNO")
@NamedQuery(name="ProductosTurno.findAll", query="SELECT p FROM ProductosTurno p")
public class ProductosTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="Id")
	private long id;

	@Column(name="Fecha")
	private Timestamp fecha;

	@Column(name="Galones")
	private double galones;

	@Column(name="Isla")
	private int isla;

	@Column(name="Producto")
	private String producto;

	@Column(name="Turno")
	private int turno;

	@Column(name="Valor")
	private double valor;

	public ProductosTurno() {
	}

	public ProductosTurno(Timestamp fecha, double galones, String producto, double valor) {
		super();
		this.fecha = fecha;
		this.galones = galones;
		this.producto = producto;
		this.valor = valor;
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

	public double getGalones() {
		return this.galones;
	}

	public void setGalones(double galones) {
		this.galones = galones;
	}

	public int getIsla() {
		return this.isla;
	}

	public void setIsla(int isla) {
		this.isla = isla;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getTurno() {
		return this.turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}