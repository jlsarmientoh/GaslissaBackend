/**
 * 
 */
package co.com.gaslissa.expo.entity;

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
 * The persistent class for the VOLUMENES_TANQUE database table.
 * 
 */
@Entity
@Table(name="VOLUMENES_TANQUE")
@NamedQuery(name="VolumenesTanque.findAll", query="SELECT v FROM VolumenesTanque v")
public class VolumenesTanque {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_VOLUMEN")
	private long idVolumen;
	
	@ManyToOne
	@JoinColumn(name="ID_TANQUE")
	private Tanque tanque;
	
	@Column(name="LECTURA_CM")
	private double lecturaCm;
	
	@Column(name="VOLUMEN_GAL")
	private double volumenGal;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	public long getIdVolumen() {
		return idVolumen;
	}

	public void setIdVolumen(long idVolumen) {
		this.idVolumen = idVolumen;
	}

	public Tanque getTanque() {
		return tanque;
	}

	public void setTanque(Tanque tanque) {
		this.tanque = tanque;
	}

	public double getLecturaCm() {
		return lecturaCm;
	}

	public void setLecturaCm(double lecturaCm) {
		this.lecturaCm = lecturaCm;
	}

	public double getVolumenGal() {
		return volumenGal;
	}

	public void setVolumenGal(double volumenGal) {
		this.volumenGal = volumenGal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
