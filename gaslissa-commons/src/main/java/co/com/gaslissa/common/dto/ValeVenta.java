package co.com.gaslissa.common.dto;

import java.io.Serializable;
import java.util.Date;

public class ValeVenta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4903844081091924071L;

	private double cantidad;

	private String cliente;

	private int codEmp;

	private double descuento;

	private Date fecha;

	private int isla;

	private String nit;

	private String producto;

	private long tiquete_Nro;

	private double total;

	private int turno;

	private String placa;
	
	private double kilometraje;

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(int codEmp) {
		this.codEmp = codEmp;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIsla() {
		return isla;
	}

	public void setIsla(int isla) {
		this.isla = isla;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public long getTiquete_Nro() {
		return tiquete_Nro;
	}

	public void setTiquete_Nro(long tiquete_Nro) {
		this.tiquete_Nro = tiquete_Nro;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
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
}
