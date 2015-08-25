/**
 * 
 */
package co.com.gaslissa.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * @author Jorge
 *
 */
public class CierreTurno implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4316036913870266004L;

	private Date fecha;
	
	private int isla;
	
	private int turno;
	
	private int empleado;
	
	private double totalVentas;
	
	private double totalConsumos;
	
	private List<MedioDePago> mediosDePago;
	
	private List<Consumo> consumos;

	@JsonSerialize(using=DateSerializer.class)
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

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	public double getTotalVentas() {
		return totalVentas;
	}

	public void setTotalVentas(double totalVentas) {
		this.totalVentas = totalVentas;
	}

	public double getTotalConsumos() {
		return totalConsumos;
	}

	public void setTotalConsumos(double totalConsumos) {
		this.totalConsumos = totalConsumos;
	}

	public List<MedioDePago> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(List<MedioDePago> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}
}
