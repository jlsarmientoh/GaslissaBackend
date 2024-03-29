package co.com.gaslissa.common.dto;

import java.io.Serializable;
import java.util.List;

public class MedioDePago implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -326530471827651474L;
	
	private long id;

	private String nombre;
	
	private double valor;
	
	private boolean detalle;
	
	private List<ValeVenta> vales;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isDetalle() {
		return detalle;
	}

	public void setDetalle(boolean detalle) {
		this.detalle = detalle;
	}

	public List<ValeVenta> getVales() {
		return vales;
	}

	public void setVales(List<ValeVenta> vales) {
		this.vales = vales;
	}
}
