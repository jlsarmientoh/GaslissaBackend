package co.com.gaslissa.servipunto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	@Column(name="COD_CLI")
	private String codCli;
	
	@Column(name="NOMBRE ")
	private String nombre;

	@Column(name="DIR_OFICINA")
	private String dirOficina;
	
	@Column(name="IgNit")
	private short igNit;

	@Column(name="NIT")
	private String nit;

	@Column(name="TEL_OFICINA")
	private String telOficina;

	@Column(name="TIPO_NIT")
	private String tipoNit;

	public Cliente() {
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirOficina() {
		return dirOficina;
	}

	public void setDirOficina(String dirOficina) {
		this.dirOficina = dirOficina;
	}

	public short getIgNit() {
		return igNit;
	}

	public void setIgNit(short igNit) {
		this.igNit = igNit;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getTelOficina() {
		return telOficina;
	}

	public void setTelOficina(String telOficina) {
		this.telOficina = telOficina;
	}

	public String getTipoNit() {
		return tipoNit;
	}

	public void setTipoNit(String tipoNit) {
		this.tipoNit = tipoNit;
	}
}