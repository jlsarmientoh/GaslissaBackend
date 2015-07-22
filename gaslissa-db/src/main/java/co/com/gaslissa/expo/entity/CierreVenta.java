package co.com.gaslissa.expo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CIERRE_VENTAS database table.
 * 
 */
@Entity
@Table(name="CIERRE_VENTAS")
@NamedQuery(name="CierreVenta.findAll", query="SELECT c FROM CierreVenta c")
public class CierreVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_CIERRE")
	private long idCierre;

	@Column(name="BIG_PASS")
	private double bigPass;

	@Column(name="COD_EMPLEADO")
	private long codEmpleado;

	@Column(name="CREDITOS")
	private double creditos;

	@Column(name="EFECTIVO")
	private double efectivo;

	@Column(name="FECHA")
	private Timestamp fecha;

	@Column(name="ISLA")
	private long isla;

	@Column(name="OTROS")
	private double otros;

	@Column(name="SODEXO")
	private double sodexo;

	@Column(name="TARJETA_PLUS")
	private double tarjetaPlus;

	@Column(name="TARJETAS")
	private double tarjetas;

	@Column(name="TICKET_TRONIK")
	private double ticketTronik;

	@Column(name="TOTAL_VENTAS")
	private double totalVentas;

	@Column(name="TURNO")
	private long turno;

	//bi-directional many-to-one association to DetalleCierre
	@OneToMany(mappedBy="cierreVenta")
	private List<DetalleCierre> detalleCierres;

	public CierreVenta() {
	}

	public CierreVenta(double bigPass, double creditos, double efectivo, Timestamp fecha, double otros, double sodexo,
			double tarjetaPlus, double tarjetas, double ticketTronik, double totalVentas) {
		super();
		this.bigPass = bigPass;
		this.creditos = creditos;
		this.efectivo = efectivo;
		this.fecha = fecha;
		this.otros = otros;
		this.sodexo = sodexo;
		this.tarjetaPlus = tarjetaPlus;
		this.tarjetas = tarjetas;
		this.ticketTronik = ticketTronik;
		this.totalVentas = totalVentas;
	}



	public long getIdCierre() {
		return this.idCierre;
	}

	public void setIdCierre(long idCierre) {
		this.idCierre = idCierre;
	}

	public double getBigPass() {
		return this.bigPass;
	}

	public void setBigPass(double bigPass) {
		this.bigPass = bigPass;
	}

	public long getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(long codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public double getCreditos() {
		return this.creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public double getEfectivo() {
		return this.efectivo;
	}

	public void setEfectivo(double efectivo) {
		this.efectivo = efectivo;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public long getIsla() {
		return this.isla;
	}

	public void setIsla(long isla) {
		this.isla = isla;
	}

	public double getOtros() {
		return this.otros;
	}

	public void setOtros(double otros) {
		this.otros = otros;
	}

	public double getSodexo() {
		return this.sodexo;
	}

	public void setSodexo(double sodexo) {
		this.sodexo = sodexo;
	}

	public double getTarjetaPlus() {
		return this.tarjetaPlus;
	}

	public void setTarjetaPlus(double tarjetaPlus) {
		this.tarjetaPlus = tarjetaPlus;
	}

	public double getTarjetas() {
		return this.tarjetas;
	}

	public void setTarjetas(double tarjetas) {
		this.tarjetas = tarjetas;
	}

	public double getTicketTronik() {
		return this.ticketTronik;
	}

	public void setTicketTronik(double ticketTronik) {
		this.ticketTronik = ticketTronik;
	}

	public double getTotalVentas() {
		return this.totalVentas;
	}

	public void setTotalVentas(double totalVentas) {
		this.totalVentas = totalVentas;
	}

	public long getTurno() {
		return this.turno;
	}

	public void setTurno(long turno) {
		this.turno = turno;
	}

	public List<DetalleCierre> getDetalleCierres() {
		return this.detalleCierres;
	}

	public void setDetalleCierres(List<DetalleCierre> detalleCierres) {
		this.detalleCierres = detalleCierres;
	}

	public DetalleCierre addDetalleCierre(DetalleCierre detalleCierre) {
		getDetalleCierres().add(detalleCierre);
		detalleCierre.setCierreVenta(this);

		return detalleCierre;
	}

	public DetalleCierre removeDetalleCierre(DetalleCierre detalleCierre) {
		getDetalleCierres().remove(detalleCierre);
		detalleCierre.setCierreVenta(null);

		return detalleCierre;
	}

}