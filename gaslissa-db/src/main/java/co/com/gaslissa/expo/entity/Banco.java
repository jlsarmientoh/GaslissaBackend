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
 * The persistent class for the BANCOS database table.
 * 
 */
@Entity
@Table(name="BANCOS")
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_BANCO")
	private long idBanco;

	@Column(name="NOMBRE")
	private String nombre;

	public Banco() {
	}

	public long getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}