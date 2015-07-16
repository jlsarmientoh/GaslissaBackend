package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the EGRESOS database table.
 * 
 */
@Entity
@Table(name="EGRESOS")
@NamedQuery(name="Egreso.findAll", query="SELECT e FROM Egreso e")
public class Egreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_EGRESO")
	private long idEgreso;

	@Column(name="BENEFICIARIO")
	private String beneficiario;

	@Column(name="FECHA")
	private Timestamp fecha;

	@Column(name="FECHA_APLICA")
	private Timestamp fechaAplica;

	@Column(name="ISLA")
	private int isla;

	@Column(name="NUMERO")
	private long numero;

	@Column(name="TIPO_IDENTIFICACION")
	private long tipoIdentificacion;

	@Column(name="VALOR")
	private double valor;

	public Egreso() {
	}

	public long getIdEgreso() {
		return this.idEgreso;
	}

	public void setIdEgreso(long idEgreso) {
		this.idEgreso = idEgreso;
	}

	public String getBeneficiario() {
		return this.beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaAplica() {
		return this.fechaAplica;
	}

	public void setFechaAplica(Timestamp fechaAplica) {
		this.fechaAplica = fechaAplica;
	}

	public int getIsla() {
		return this.isla;
	}

	public void setIsla(int isla) {
		this.isla = isla;
	}

	public long getNumero() {
		return this.numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public long getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(long tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}