package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CLIENTES database table.
 * 
 */
@Entity
@Table(name="CLIENTES")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_CLIENTE")
	private long idCliente;

	@Column(name="CODIGO")
	private String codigo;

	@Column(name="CONSECUTIVO")
	private String consecutivo;

	@Column(name="CONTACTO")
	private String contacto;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="EMAIL")
	private String email;

	@Column(name="IDENTIFICACION")
	private String identificacion;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TELEFONO")
	private String telefono;

	@Column(name="TIPO_ID")
	private long tipoId;

	public Cliente() {
	}

	public Cliente(String identificacion, String nombre) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
	}



	public long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public long getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(long tipoId) {
		this.tipoId = tipoId;
	}

}