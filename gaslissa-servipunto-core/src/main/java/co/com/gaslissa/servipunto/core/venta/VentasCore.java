/**
 * 
 */
package co.com.gaslissa.servipunto.core.venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.dto.ValeVenta;
import co.com.gaslissa.common.enums.EstadoCliente;
import co.com.gaslissa.servipunto.core.exception.CoreException;
import co.com.gaslissa.servipunto.core.util.CoreUtil;
import co.com.gaslissa.servipunto.entity.ViewVenta;
import co.com.gaslissa.servipunto.repository.ViewVentaRepository;

/**
 * @author Jorge
 *
 */
public class VentasCore {
	
	final static Logger logger = LoggerFactory.getLogger(VentasCore.class);
	
	private final String[] gruposIsla;
	
	private final ViewVentaRepository viewVentaRepository;
	
	/**
	 * 
	 * @param gruposIsla
	 * @param viewVentaRepository
	 */
	public VentasCore(String[] gruposIsla, ViewVentaRepository viewVentaRepository) {
		super();
		this.gruposIsla = gruposIsla;
		this.viewVentaRepository = viewVentaRepository;
	}

	/**
	 * Retorna las ventas de los clientes fidelizados
	 * @param codEmp
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CoreException
	 * @throws CierreTurnoException
	 */
	public List<ValeVenta> consultarVentasFidelizados(
			long codEmp,
			Date desde,
			Date hasta,
			int isla,
			int turno) throws CoreException{
		try{
			List<ViewVenta> ventas = null;
			List<ValeVenta> vales = null;
	        
			ventas = this.viewVentaRepository.consultarVentasFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, turno, CoreUtil.getIslas(isla, this.gruposIsla), Long.toString(codEmp));
			
			if(ventas != null){
				vales = new ArrayList<ValeVenta>();
				
				for(ViewVenta venta : ventas){
					ValeVenta vale = new ValeVenta();
					vale.setCantidad(venta.getCantidad().doubleValue());
					vale.setCliente(venta.getCliente().trim());
					vale.setCodEmp(Integer.valueOf(venta.getCodEmp().trim()));
					vale.setDescuento(venta.getDescuento().doubleValue());
					vale.setFecha(new Date(venta.getFecha().getTime()));
					vale.setIsla(isla);
					vale.setKilometraje(venta.getKilAct().intValue());
					vale.setNit(venta.getNit().trim());
					vale.setPlaca(venta.getVehiculo_Placa().trim());
					vale.setProducto(venta.getProducto().trim());
					vale.setTiquete_Nro(venta.getTiquete_Nro());
					vale.setTotal(venta.getTotal().doubleValue());
					vale.setTurno(venta.getTurno());
					vales.add(vale);
				}
			}
			
			return vales;
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de ventas fidelizadas: " + e.getMessage(), e);
			throw new CoreException("No se puede realizar la consulta de ventas fidelizadas: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param codEmp
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CoreException
	 * @throws CoreException
	 */
	public List<ValeVenta> consultarVentasNoFidelizados(
			long codEmp,
			Date desde,
			Date hasta,
			int isla,
			int turno) throws CoreException{
		try{
			List<ViewVenta> ventas = null;
			List<ValeVenta> vales = null;
			
			ventas = this.viewVentaRepository.consultarVentasNoFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, turno, CoreUtil.getIslas(isla, this.gruposIsla), Long.toString(codEmp));
			
			if(ventas != null){
				vales = new ArrayList<ValeVenta>();
				
				for(ViewVenta venta : ventas){
					ValeVenta vale = new ValeVenta();
					vale.setCantidad(venta.getCantidad().doubleValue());
					vale.setCliente(venta.getCliente().trim());
					vale.setCodEmp(Integer.valueOf(venta.getCodEmp().trim()));
					vale.setDescuento(venta.getDescuento().doubleValue());
					vale.setFecha(new Date(venta.getFecha().getTime()));
					vale.setIsla(isla);
					vale.setKilometraje(venta.getKilAct().intValue());
					vale.setNit(venta.getNit().trim());
					vale.setPlaca(venta.getVehiculo_Placa().trim());
					vale.setProducto(venta.getProducto().trim());
					vale.setTiquete_Nro(venta.getTiquete_Nro());
					vale.setTotal(venta.getTotal().doubleValue());
					vale.setTurno(venta.getTurno());
					vales.add(vale);
				}
			}
			
			return vales;
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage(), e);
			throw new CoreException("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage());
		}
	}
	
	
	/**
	 * Retorna el total de las ventas fidelizadas de acuerdo a
	 * los par�metros dados
	 * @param codEmpleado
	 * @param turno
	 * @param isla
	 * @param desde
	 * @param hasta
	 * @return
	 * @throws CoreException
	 */
	public double consultarTotalVentasFidelizadas(
			long codEmpleado, 
			int turno, 
			int isla, 
			Date desde, 
			Date hasta) throws CoreException {
        try{
            return this.viewVentaRepository.consultarTotalVentasFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, turno, CoreUtil.getIslas(isla, this.gruposIsla), Long.toString(codEmpleado)).doubleValue();                
        }catch (Exception ex){
        	logger.error("No se puede calcular el total de las ventas fidelizadas desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede calcular el total de las ventas fidelizadas desde la base de datos Servipunto: " + ex.getMessage());
        }
    }
	
	/**
	 * Retorna la informaci�n de un ticket en particular 
	 * y para un turno en espec�fico
	 * @param nroTiquete
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CoreException
	 */
	public ValeVenta consultarVentaTurno(
			long nroTiquete, 
			Date desde, 
			Date hasta, 
			int isla, 
			int turno) throws CoreException{
		try{
			ValeVenta vale = null;
            ViewVenta venta = this.viewVentaRepository.consultarVentasByTiqueteTurno(nroTiquete, desde, hasta, turno, CoreUtil.getIslas(isla, this.gruposIsla));
            
            if(venta != null){
            	vale = new ValeVenta();
				vale.setCantidad(venta.getCantidad().doubleValue());
				vale.setCliente(venta.getCliente().trim());
				vale.setCodEmp(Integer.valueOf(venta.getCodEmp().trim()));
				vale.setDescuento(venta.getDescuento().doubleValue());
				vale.setFecha(new Date(venta.getFecha().getTime()));
				vale.setIsla(isla);
				vale.setKilometraje(venta.getKilAct().intValue());
				vale.setNit(venta.getNit().trim());
				vale.setPlaca(venta.getVehiculo_Placa().trim());
				vale.setProducto(venta.getProducto().trim());
				vale.setTiquete_Nro(venta.getTiquete_Nro());
				vale.setTotal(venta.getTotal().doubleValue());
				vale.setTurno(venta.getTurno());
            }
            
            return vale;
        }catch (Exception ex){
        	logger.error("No se puede obtener informaci�n del ticket # "+ nroTiquete + " desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede obtener informaci�n del ticket # "+ nroTiquete + " desde la base de datos Servipunto: " + ex.getMessage());
        }
	}
	
	public ValeVenta consultarVenta(long id) throws CoreException{
		try{
			ValeVenta vale = null;
            ViewVenta venta = this.viewVentaRepository.findOne(id);
            
            if(venta != null){
            	vale = new ValeVenta();
				vale.setCantidad(venta.getCantidad().doubleValue());
				vale.setCliente(venta.getCliente().trim());
				vale.setCodEmp(Integer.valueOf(venta.getCodEmp().trim()));
				vale.setDescuento(venta.getDescuento().doubleValue());
				vale.setFecha(new Date(venta.getFecha().getTime()));
				vale.setIsla(venta.getIsla());
				vale.setKilometraje(venta.getKilAct().intValue());
				vale.setNit(venta.getNit().trim());
				vale.setPlaca(venta.getVehiculo_Placa().trim());
				vale.setProducto(venta.getProducto().trim());
				vale.setTiquete_Nro(venta.getTiquete_Nro());
				vale.setTotal(venta.getTotal().doubleValue());
				vale.setTurno(venta.getTurno());
            }
            
            return vale;
        }catch (Exception ex){
        	logger.error("No se puede obtener informaci�n del ticket # "+ id + " desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede obtener informaci�n del ticket # "+ id + " desde la base de datos Servipunto: " + ex.getMessage());
        }
	}
	
}
