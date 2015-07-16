package co.com.gaslissa.expo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the TANQUES database table.
 * 
 */
@Entity
@Table(name="TANQUES")
@NamedQuery(name="Tanque.findAll", query="SELECT t FROM Tanque t")
public class Tanque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_TANQUE")
	private int idTanque;

	@Column(name="DESCRIPCION")
	private String descripcion;

	public Tanque() {
	}

	public int getIdTanque() {
		return this.idTanque;
	}

	public void setIdTanque(int idTanque) {
		this.idTanque = idTanque;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}