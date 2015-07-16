/**
 * 
 */
package co.com.gaslissa.expo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the DETALLE_CIERRE database table.
 *
 */
@Entity
@Table(name="DETALLE_CIERRE")
@NamedQuery(name="DetalleCierre.findAll", query="SELECT d FROM DetalleCierre d")
public class DetalleCierre {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_DETALLE")
	private long idDetalle;
	
	@Column(name="TOTAL")
	private double total;
	
	@ManyToOne
	@JoinColumn(name="ID_CIERRE")
	private CierreVenta cierreVenta;
	
	@ManyToOne
	@JoinColumn(name="ID_MODO_PAGO")
	private ModoPago modoPago;

	public long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public CierreVenta getCierreVenta() {
		return cierreVenta;
	}

	public void setCierreVenta(CierreVenta cierreVenta) {
		this.cierreVenta = cierreVenta;
	}

	public ModoPago getModoPago() {
		return modoPago;
	}

	public void setModoPago(ModoPago modoPago) {
		this.modoPago = modoPago;
	}
}
