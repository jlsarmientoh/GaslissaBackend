package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the INGRESOS database table.
 * 
 */
@Entity
@Table(name="INGRESOS")
@NamedQuery(name="Ingreso.findAll", query="SELECT i FROM Ingreso i")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_INGRESO")
	private long idIngreso;

	@Column(name="CONSIGNACION")
	private long consignacion;

	@Column(name="FECHA")
	private Timestamp fecha;

	@Column(name="TIPO_IDENTIFICACION")
	private long tipoIdentificacion;

	@Column(name="VALOR")
	private double valor;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="ID_BANCO")
	private Banco banco;

	public Ingreso() {
	}

	public long getIdIngreso() {
		return this.idIngreso;
	}

	public void setIdIngreso(long idIngreso) {
		this.idIngreso = idIngreso;
	}

	public long getConsignacion() {
		return this.consignacion;
	}

	public void setConsignacion(long consignacion) {
		this.consignacion = consignacion;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

}