package co.com.gaslissa.common.dto;

import java.io.Serializable;

public class Islero implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6015208540435958564L;

	private String codigo;
	
	private String nombre;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
