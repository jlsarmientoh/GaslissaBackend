package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_IDENTIFICACION database table.
 * 
 */
@Entity
@Table(name="TIPO_IDENTIFICACION")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_TIPO")
	private long idTipo;

	@Column(name="NOMBRE")
	private String nombre;

	public TipoIdentificacion() {
	}

	public long getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}