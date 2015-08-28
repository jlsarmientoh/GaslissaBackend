package co.com.gaslissa.core.cierre;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.common.dto.Consumo;
import co.com.gaslissa.common.dto.MedioDePago;
import co.com.gaslissa.common.dto.ValeVenta;
import co.com.gaslissa.core.exception.CierreTurnoException;
import co.com.gaslissa.expo.entity.CierreVenta;
import co.com.gaslissa.expo.entity.DetalleCierre;
import co.com.gaslissa.expo.entity.ModoPago;
import co.com.gaslissa.expo.entity.ProductosTurno;
import co.com.gaslissa.expo.entity.Venta;
import co.com.gaslissa.expo.repository.CierreVentaRepository;
import co.com.gaslissa.expo.repository.DetalleCierreRepository;
import co.com.gaslissa.expo.repository.ModoPagoRepository;
import co.com.gaslissa.expo.repository.ProductosTurnoRepository;
import co.com.gaslissa.expo.repository.VentaRepository;

public class CierreCore {
	
	final static Logger logger = LoggerFactory.getLogger(CierreCore.class);
	
	private final VentaRepository ventaRepository;
	
	private final CierreVentaRepository cierreVentaRepository;
	
	private final DetalleCierreRepository detalleCierreRepository;
	
	private final ProductosTurnoRepository productosTurnoRepository;
	

	public CierreCore(VentaRepository ventaRepository,
			CierreVentaRepository cierreVentaRepository,
			DetalleCierreRepository detalleCierreRepository,
			ProductosTurnoRepository productosTurnoRepository) {
		super();
		this.ventaRepository = ventaRepository;
		this.cierreVentaRepository = cierreVentaRepository;
		this.detalleCierreRepository = detalleCierreRepository;
		this.productosTurnoRepository = productosTurnoRepository;
	}

	/**
	 * Revisa si ya existe un cierre para los par�metros dados.
	 * @param codEmpleado
	 * @param turno
	 * @param isla
	 * @param desde
	 * @param hasta
	 * @return True si el cierre existe. De lo contrario retorna False.
	 * @throws CierreTurnoException
	 */
	public boolean existeCierre(
			long codEmpleado, 
			long turno, 
			long isla, 
			Date desde, 
			Date hasta) throws CierreTurnoException{
        try{
        	long i = 0;
        	i = this.cierreVentaRepository.consultarCuentaCierres(
        			desde,
        			hasta,
        			turno,
        			isla,
        			codEmpleado);
            
        	if(i > 0){
        		return true;
        	}else{
        		return false;
        	}            		
        }catch (Exception ex){
        	logger.error("No se puede revisar si el cierre ya existe: " + ex.getMessage(), ex);
            throw new CierreTurnoException("No se puede revisar si el cierre ya existe: " + ex.getMessage());
        }
    }
	
	/**
	 * Realizar las operaciones de registro de un cierre
	 * @param cierre
	 * @return
	 * @throws CierreTurnoException
	 */
	@Transactional(rollbackFor = CierreTurnoException.class)
	public long guardarCierre(CierreTurno cierre) throws CierreTurnoException{
		try{
			/*
			 *Se guardan los datos del cierre 
			 */
			CierreVenta cierreVenta = new CierreVenta();
			cierreVenta.setCodEmpleado(cierre.getEmpleado());
			cierreVenta.setFecha(new Timestamp(cierre.getFecha().getTime()));
			cierreVenta.setIsla(cierre.getIsla());
			cierreVenta.setTurno(cierre.getTurno());
			cierreVenta.setTotalVentas(cierre.getTotalVentas());
			
			cierreVenta = this.cierreVentaRepository.save(cierreVenta);
			
			/*
			 * Se guardan los detalles del cierre, medios de pago
			 */
			List<MedioDePago> medios = cierre.getMediosDePago();
			
			if(medios == null || medios.isEmpty())
				throw new CierreTurnoException("Faltan los medios de pago para el cierre");
			
			for(MedioDePago medio : medios){
				DetalleCierre detalle = new DetalleCierre();
				detalle.setCierreVenta(cierreVenta);
				detalle.setModoPago(new ModoPago(medio.getId()));
				detalle.setTotal(medio.getValor());
				
				this.detalleCierreRepository.save(detalle);
				/*
				 * En caso de tener ventas asociadas, se guardan
				 */
				List<ValeVenta> vales = medio.getVales();
				if(vales != null && !vales.isEmpty()){
					for(ValeVenta vale : vales){
						Venta venta = new Venta();
						venta.setCliente(vale.getCliente());
						venta.setCodEmpleado(vale.getCodEmp());
						venta.setFecha(new Timestamp(vale.getFecha().getTime()));
						venta.setFechaRegistro(new Timestamp(new Date().getTime()));
						venta.setIsla(vale.getIsla());
						venta.setKilometraje(vale.getKilometraje());
						venta.setModoPago(new ModoPago(medio.getId()));
						venta.setNit(vale.getNit());
						venta.setPlaca(vale.getPlaca());
						venta.setProducto(vale.getProducto());
						venta.setTiquete(vale.getTiquete_Nro());
						venta.setTotal(vale.getTotal());
						venta.setTurno(vale.getTurno());
						
						this.ventaRepository.save(venta);
					}
				}
			}
			
			/*
			 * Se guardan los consumos del turno
			 */
			List<Consumo> consumos = cierre.getConsumos();
			if(consumos == null || consumos.isEmpty())
				throw new CierreTurnoException("Faltan los consumos para el cierre");
			
			for(Consumo consumo : consumos){
				ProductosTurno pt = new ProductosTurno();
				pt.setFecha(new Timestamp(consumo.getFecha().getTime()));
				pt.setGalones(consumo.getGalones());
				pt.setIsla(consumo.getIsla());
				pt.setProducto(consumo.getProducto());
				pt.setTurno(consumo.getTurno());
				pt.setValor(consumo.getValor());
				
				this.productosTurnoRepository.save(pt);
			}
			
			return cierreVenta.getIdCierre();
		}catch(Exception ex){
			logger.error("No se pudo realizar el cierre: " + ex.getMessage(), ex);
			throw new CierreTurnoException("No se pudo realizar el cierre: " + ex.getMessage());
		}
	}
	
	public List<CierreTurno> consultarCierres( 
			Date desde, 
			Date hasta) throws CierreTurnoException{
		try{
			List<CierreTurno> cierres = null;
			List<CierreVenta> cierresVenta = this.cierreVentaRepository.consultarCierres(desde, hasta);
			
			if(cierresVenta != null && !cierresVenta.isEmpty()){
				cierres = new ArrayList<CierreTurno>();
				
				for(CierreVenta cierreVenta : cierresVenta){
					/*
					 * Se cargan los datos del cierre
					 */
					CierreTurno cierre = new CierreTurno();
					cierre.setId(cierreVenta.getIdCierre());
					cierre.setEmpleado((int) cierreVenta.getCodEmpleado());
					cierre.setFecha(new Date(cierreVenta.getFecha().getTime()));
					cierre.setIsla((int)cierreVenta.getIsla());
					cierre.setTotalVentas(cierreVenta.getTotalVentas());
					cierre.setTurno((int) cierreVenta.getTurno());
					
					/*
					 * Se carga la información del detalle de cada cierres
					 */
					List<DetalleCierre> detalles = this.detalleCierreRepository.consultarDetallesCierre(cierreVenta.getIdCierre());
					
					if(detalles != null && !detalles.isEmpty()){
						List<MedioDePago> mediosDePago = new ArrayList<MedioDePago>();
						
						for(DetalleCierre detalle : detalles){
							MedioDePago medioDePago = new MedioDePago();
							medioDePago.setId(detalle.getModoPago().getIdModoPago());
							medioDePago.setNombre(detalle.getModoPago().getNombre());
							medioDePago.setDetalle(detalle.getModoPago().getDetalle());
							medioDePago.setValor(detalle.getTotal());
							
							mediosDePago.add(medioDePago);
						}
						
						cierre.setMediosDePago(mediosDePago);
					}
					
					/**
					 * Se cargan los productos del cierre
					 */
					List<ProductosTurno> productosTurno = this.productosTurnoRepository.consultarProductosTurno((int)cierreVenta.getIsla(), (int)cierreVenta.getTurno(), cierre.getFecha(), cierre.getFecha());
					
					if(productosTurno != null && !productosTurno.isEmpty()){
						List<Consumo> consumos = new ArrayList<Consumo>();
						
						for(ProductosTurno pt : productosTurno){
							Consumo consumo = new Consumo();
							consumo.setFecha(pt.getFecha());
							consumo.setGalones(pt.getGalones());
							consumo.setIsla(pt.getIsla());
							consumo.setProducto(pt.getProducto());
							consumo.setTurno(pt.getTurno());
							consumo.setValor(pt.getValor());
							
							consumos.add(consumo);
						}
						
						cierre.setConsumos(consumos);
					}
					/*
					 * Se añade el DTO del cierre a la lista
					 */
					cierres.add(cierre);
				}
			}
			
			return cierres;
		} catch(Exception ex){
			logger.error("No se puede consultar la información de cierres para las fechas seleccionadas: " + ex.getMessage());
			throw new CierreTurnoException("No se puede consultar la información de cierres para las fechas seleccionadas: " + ex.getMessage());
		}
	}
}
