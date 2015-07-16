package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the CIERRE_EFECTIVO database table.
 * 
 */
@Entity
@Table(name="CIERRE_EFECTIVO")
@NamedQuery(name="CierreEfectivo.findAll", query="SELECT c FROM CierreEfectivo c")
public class CierreEfectivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_CIERRE")
	private long idCierre;

	@Column(name="EFECTIVO")
	private BigDecimal efectivo;

	@Column(name="EGRESOS")
	private BigDecimal egresos;

	@Column(name="ESTADO")
	private int estado;

	@Column(name="FECHA")
	private Timestamp fecha;

	public CierreEfectivo() {
	}

	public long getIdCierre() {
		return this.idCierre;
	}

	public void setIdCierre(long idCierre) {
		this.idCierre = idCierre;
	}

	public BigDecimal getEfectivo() {
		return this.efectivo;
	}

	public void setEfectivo(BigDecimal efectivo) {
		this.efectivo = efectivo;
	}

	public BigDecimal getEgresos() {
		return this.egresos;
	}

	public void setEgresos(BigDecimal egresos) {
		this.egresos = egresos;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}