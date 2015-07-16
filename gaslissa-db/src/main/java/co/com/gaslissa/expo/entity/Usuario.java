package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_USUARIO")
	private String idUsuario;

	@Column(name="ES_ADMIN")
	private int esAdmin;

	@Column(name="PWD")
	private String pwd;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getEsAdmin() {
		return this.esAdmin;
	}

	public void setEsAdmin(int esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}