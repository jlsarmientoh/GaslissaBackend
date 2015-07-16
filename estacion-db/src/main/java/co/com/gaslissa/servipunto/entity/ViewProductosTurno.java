package co.com.gaslissa.servipunto.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.NamedQuery;


/**
 * The persistent class for the ViewProductosTurno database table.
 * 
 */
@NamedQuery(
	name="ViewProductosTurno.findAll", 
	query="SELECT NEW co.com.gaslissa.servipunto.entity.ViewProductosTurno(v.fecha, v.galones, v.isla, v.producto, v.turno, v.valor) FROM ViewProductosTurno v")
public class ViewProductosTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp fecha;

	private double galones;

	private int isla;

	private String producto;

	private int turno;

	private double valor;

	public ViewProductosTurno() {
	}
	
	public ViewProductosTurno(Timestamp fecha, double galones, int isla, String producto, int turno, double valor) {
		super();
		this.fecha = fecha;
		this.galones = galones;
		this.isla = isla;
		this.producto = producto;
		this.turno = turno;
		this.valor = valor;
	}


	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public double getGalones() {
		return galones;
	}

	public void setGalones(double galones) {
		this.galones = galones;
	}

	public int getIsla() {
		return isla;
	}

	public void setIsla(int isla) {
		this.isla = isla;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}