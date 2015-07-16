package co.com.gaslissa.servipunto.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Entity
@Table(name="EMPLEADO")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_EMP")
	private String codEmp;

	@Column(name="ACTIVO")
	private String activo;

	@Column(name="CEDULA")
	private String cedula;

	@Column(name="CIUDAD_NACIM")
	private String ciudadNacim;

	@Column(name="CLAVE")
	private String clave;

	@Column(name="COMENTARIOS")
	private String comentarios;

	@Column(name="COMISION")
	private BigDecimal comision;

	@Column(name="DIRECCION")
	private String direccion;

	@Column(name="ESTUDIOS")
	private String estudios;

	@Column(name="EXPERIENCIA")
	private String experiencia;

	@Column(name="FECH_ULT_ACTU")
	private int fechUltActu;

	@Column(name="FECHA_INGRES")
	private int fechaIngres;

	@Column(name="FECHA_NACIMI")
	private int fechaNacimi;

	@Column(name="LUGAR_EXPEDI")
	private String lugarExpedi;

	@Column(name="MIN_CUO")
	private BigDecimal minCuo;

	@Column(name="NIVEL")
	private String nivel;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="REFERENCIA")
	private String referencia;

	@Column(name="REQ_IDENTIFI")
	private short reqIdentifi;

	@Column(name="SUELDO")
	private int sueldo;

	@Column(name="TELEFONOS")
	private String telefonos;

	@Column(name="TIPO")
	private String tipo;

	@Column(name="ULT_ACTULIZA")
	private String ultActuliza;

	public Empleado() {
	}

	public String getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudadNacim() {
		return this.ciudadNacim;
	}

	public void setCiudadNacim(String ciudadNacim) {
		this.ciudadNacim = ciudadNacim;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public BigDecimal getComision() {
		return this.comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstudios() {
		return this.estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public String getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public int getFechUltActu() {
		return this.fechUltActu;
	}

	public void setFechUltActu(int fechUltActu) {
		this.fechUltActu = fechUltActu;
	}

	public int getFechaIngres() {
		return this.fechaIngres;
	}

	public void setFechaIngres(int fechaIngres) {
		this.fechaIngres = fechaIngres;
	}

	public int getFechaNacimi() {
		return this.fechaNacimi;
	}

	public void setFechaNacimi(int fechaNacimi) {
		this.fechaNacimi = fechaNacimi;
	}

	public String getLugarExpedi() {
		return this.lugarExpedi;
	}

	public void setLugarExpedi(String lugarExpedi) {
		this.lugarExpedi = lugarExpedi;
	}

	public BigDecimal getMinCuo() {
		return this.minCuo;
	}

	public void setMinCuo(BigDecimal minCuo) {
		this.minCuo = minCuo;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public short getReqIdentifi() {
		return this.reqIdentifi;
	}

	public void setReqIdentifi(short reqIdentifi) {
		this.reqIdentifi = reqIdentifi;
	}

	public int getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUltActuliza() {
		return this.ultActuliza;
	}

	public void setUltActuliza(String ultActuliza) {
		this.ultActuliza = ultActuliza;
	}

}