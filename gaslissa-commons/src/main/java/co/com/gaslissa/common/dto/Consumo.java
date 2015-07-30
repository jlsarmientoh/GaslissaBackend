package co.com.gaslissa.common.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Consumo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 457358046646344108L;

	private Date fecha;

	private double galones;

	private int isla;

	private String producto;

	private int turno;

	private double valor;

	@JsonSerialize(using=DateSerializer.class)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
