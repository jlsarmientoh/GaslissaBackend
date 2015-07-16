package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the MODO_PAGO database table.
 * 
 */
@Entity
@Table(name="MODO_PAGO")
@NamedQuery(name="ModoPago.findAll", query="SELECT m FROM ModoPago m")
public class ModoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_MODO_PAGO")
	private long idModoPago;

	@Column(name="CUENTA_BANCARIA")
	private String cuentaBancaria;

	@Column(name="CUENTA_PUC")
	private BigDecimal cuentaPuc;

	@Column(name="DETALLE")
	private boolean detalle;

	@Column(name="ID_MODO_PADRE")
	private int idModoPadre;

	@Column(name="NOMBRE")
	private String nombre;

	public ModoPago() {
	}

	public long getIdModoPago() {
		return this.idModoPago;
	}

	public void setIdModoPago(long idModoPago) {
		this.idModoPago = idModoPago;
	}

	public String getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public BigDecimal getCuentaPuc() {
		return this.cuentaPuc;
	}

	public void setCuentaPuc(BigDecimal cuentaPuc) {
		this.cuentaPuc = cuentaPuc;
	}

	public boolean getDetalle() {
		return this.detalle;
	}

	public void setDetalle(boolean detalle) {
		this.detalle = detalle;
	}

	public int getIdModoPadre() {
		return this.idModoPadre;
	}

	public void setIdModoPadre(int idModoPadre) {
		this.idModoPadre = idModoPadre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}