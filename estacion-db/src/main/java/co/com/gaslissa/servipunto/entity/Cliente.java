package co.com.gaslissa.servipunto.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


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

	@Column(name="ABONOS")
	private int abonos;

	@Column(name="AGENT_RET")
	private String agentRet;

	@Column(name="ATENCION_DE")
	private String atencionDe;

	@Column(name="CARGO")
	private String cargo;

	@Column(name="CIUDAD")
	private String ciudad;

	@Column(name="COD_FOR_PAG")
	private short codForPag;

	@Column(name="COD_ICA")
	private BigDecimal codIca;

	@Column(name="COD_POSTAL")
	private String codPostal;

	@Column(name="COD_SUC")
	private short codSuc;

	@Column(name="CodigoAlterno")
	private String codigoAlterno;

	@Column(name="CORRESPONDEN")
	private String corresponden;

	@Column(name="CVC2")
	private String cvc2;

	@Column(name="DEPARTAMENTO")
	private String departamento;

	@Column(name="DESCUENTOS")
	private BigDecimal descuentos;

	@Column(name="DIR_OFICINA")
	private String dirOficina;

	@Column(name="DIR_PARTICULAR")
	private String dirParticular;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="FECH_CUMPLEANOS")
	private int fechCumpleanos;

	@Column(name="FECH_ULT")
	private int fechUlt;

	@Column(name="FECH_ULT_ACTU")
	private Timestamp fechUltActu;

	@Column(name="FECHA_CREACI")
	private int fechaCreaci;

	@Column(name="FECHA_CUMP")
	private String fechaCump;

	@Column(name="GRAN_CONT")
	private String granCont;

	@Column(name="IdTipoAutorizacionExterna")
	private short idTipoAutorizacionExterna;

	@Column(name="IgNit")
	private short igNit;

	@Column(name="LISTA_PRECIO")
	private int listaPrecio;

	@Column(name="NIT")
	private String nit;

	@Column(name="NO_PAGO")
	private String noPago;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PAGO_ANO")
	private short pagoAno;

	@Column(name="PAGO_MES")
	private short pagoMes;

	@Column(name="PASWORD")
	private String pasword;

	@Column(name="PLAZO")
	private BigDecimal plazo;

	@Column(name="PORC_DESC")
	private BigDecimal porcDesc;

	@Column(name="PRINCIPAL")
	private String principal;

	@Column(name="REGIMEN_IVA")
	private String regimenIva;

	@Column(name="REGISTRO")
	private int registro;

	@Column(name="SALDO")
	private int saldo;

	@Column(name="SECTOR")
	private short sector;

	@Column(name="TEL_FAX")
	private String telFax;

	@Column(name="TEL_MOVIL")
	private String telMovil;

	@Column(name="TEL_OFICINA")
	private String telOficina;

	@Column(name="TEL_PARTICULAR")
	private String telParticular;

	@Column(name="TIPO_CRED")
	private short tipoCred;

	@Column(name="TIPO_NIT")
	private String tipoNit;

	@Column(name="TIPO_PERS")
	private String tipoPers;

	@Column(name="TIPO_SOC")
	private String tipoSoc;

	@Column(name="TipoAutorizacion")
	private short tipoAutorizacion;

	@Column(name="TipoCredito")
	private String tipoCredito;

	@Column(name="TipoTransaccion")
	private String tipoTransaccion;

	@Column(name="TOTAL")
	private int total;

	@Column(name="TRATAMIENTO")
	private String tratamiento;

	@Column(name="ULT_ACTUALIZA")
	private String ultActualiza;

	@Column(name="USUARIO")
	private String usuario;

	@Column(name="VG_ID")
	private short vgId;

	@Column(name="ZONA")
	private short zona;

	public Cliente() {
	}

	public String getCodCli() {
		return this.codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public int getAbonos() {
		return this.abonos;
	}

	public void setAbonos(int abonos) {
		this.abonos = abonos;
	}

	public String getAgentRet() {
		return this.agentRet;
	}

	public void setAgentRet(String agentRet) {
		this.agentRet = agentRet;
	}

	public String getAtencionDe() {
		return this.atencionDe;
	}

	public void setAtencionDe(String atencionDe) {
		this.atencionDe = atencionDe;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public short getCodForPag() {
		return this.codForPag;
	}

	public void setCodForPag(short codForPag) {
		this.codForPag = codForPag;
	}

	public BigDecimal getCodIca() {
		return this.codIca;
	}

	public void setCodIca(BigDecimal codIca) {
		this.codIca = codIca;
	}

	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public short getCodSuc() {
		return this.codSuc;
	}

	public void setCodSuc(short codSuc) {
		this.codSuc = codSuc;
	}

	public String getCodigoAlterno() {
		return this.codigoAlterno;
	}

	public void setCodigoAlterno(String codigoAlterno) {
		this.codigoAlterno = codigoAlterno;
	}

	public String getCorresponden() {
		return this.corresponden;
	}

	public void setCorresponden(String corresponden) {
		this.corresponden = corresponden;
	}

	public String getCvc2() {
		return this.cvc2;
	}

	public void setCvc2(String cvc2) {
		this.cvc2 = cvc2;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public BigDecimal getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}

	public String getDirOficina() {
		return this.dirOficina;
	}

	public void setDirOficina(String dirOficina) {
		this.dirOficina = dirOficina;
	}

	public String getDirParticular() {
		return this.dirParticular;
	}

	public void setDirParticular(String dirParticular) {
		this.dirParticular = dirParticular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getFechCumpleanos() {
		return this.fechCumpleanos;
	}

	public void setFechCumpleanos(int fechCumpleanos) {
		this.fechCumpleanos = fechCumpleanos;
	}

	public int getFechUlt() {
		return this.fechUlt;
	}

	public void setFechUlt(int fechUlt) {
		this.fechUlt = fechUlt;
	}

	public Timestamp getFechUltActu() {
		return this.fechUltActu;
	}

	public void setFechUltActu(Timestamp fechUltActu) {
		this.fechUltActu = fechUltActu;
	}

	public int getFechaCreaci() {
		return this.fechaCreaci;
	}

	public void setFechaCreaci(int fechaCreaci) {
		this.fechaCreaci = fechaCreaci;
	}

	public String getFechaCump() {
		return this.fechaCump;
	}

	public void setFechaCump(String fechaCump) {
		this.fechaCump = fechaCump;
	}

	public String getGranCont() {
		return this.granCont;
	}

	public void setGranCont(String granCont) {
		this.granCont = granCont;
	}

	public short getIdTipoAutorizacionExterna() {
		return this.idTipoAutorizacionExterna;
	}

	public void setIdTipoAutorizacionExterna(short idTipoAutorizacionExterna) {
		this.idTipoAutorizacionExterna = idTipoAutorizacionExterna;
	}

	public short getIgNit() {
		return this.igNit;
	}

	public void setIgNit(short igNit) {
		this.igNit = igNit;
	}

	public int getListaPrecio() {
		return this.listaPrecio;
	}

	public void setListaPrecio(int listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNoPago() {
		return this.noPago;
	}

	public void setNoPago(String noPago) {
		this.noPago = noPago;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getPagoAno() {
		return this.pagoAno;
	}

	public void setPagoAno(short pagoAno) {
		this.pagoAno = pagoAno;
	}

	public short getPagoMes() {
		return this.pagoMes;
	}

	public void setPagoMes(short pagoMes) {
		this.pagoMes = pagoMes;
	}

	public String getPasword() {
		return this.pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public BigDecimal getPlazo() {
		return this.plazo;
	}

	public void setPlazo(BigDecimal plazo) {
		this.plazo = plazo;
	}

	public BigDecimal getPorcDesc() {
		return this.porcDesc;
	}

	public void setPorcDesc(BigDecimal porcDesc) {
		this.porcDesc = porcDesc;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getRegimenIva() {
		return this.regimenIva;
	}

	public void setRegimenIva(String regimenIva) {
		this.regimenIva = regimenIva;
	}

	public int getRegistro() {
		return this.registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public short getSector() {
		return this.sector;
	}

	public void setSector(short sector) {
		this.sector = sector;
	}

	public String getTelFax() {
		return this.telFax;
	}

	public void setTelFax(String telFax) {
		this.telFax = telFax;
	}

	public String getTelMovil() {
		return this.telMovil;
	}

	public void setTelMovil(String telMovil) {
		this.telMovil = telMovil;
	}

	public String getTelOficina() {
		return this.telOficina;
	}

	public void setTelOficina(String telOficina) {
		this.telOficina = telOficina;
	}

	public String getTelParticular() {
		return this.telParticular;
	}

	public void setTelParticular(String telParticular) {
		this.telParticular = telParticular;
	}

	public short getTipoCred() {
		return this.tipoCred;
	}

	public void setTipoCred(short tipoCred) {
		this.tipoCred = tipoCred;
	}

	public String getTipoNit() {
		return this.tipoNit;
	}

	public void setTipoNit(String tipoNit) {
		this.tipoNit = tipoNit;
	}

	public String getTipoPers() {
		return this.tipoPers;
	}

	public void setTipoPers(String tipoPers) {
		this.tipoPers = tipoPers;
	}

	public String getTipoSoc() {
		return this.tipoSoc;
	}

	public void setTipoSoc(String tipoSoc) {
		this.tipoSoc = tipoSoc;
	}

	public short getTipoAutorizacion() {
		return this.tipoAutorizacion;
	}

	public void setTipoAutorizacion(short tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}

	public String getTipoCredito() {
		return this.tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getUltActualiza() {
		return this.ultActualiza;
	}

	public void setUltActualiza(String ultActualiza) {
		this.ultActualiza = ultActualiza;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public short getVgId() {
		return this.vgId;
	}

	public void setVgId(short vgId) {
		this.vgId = vgId;
	}

	public short getZona() {
		return this.zona;
	}

	public void setZona(short zona) {
		this.zona = zona;
	}

}