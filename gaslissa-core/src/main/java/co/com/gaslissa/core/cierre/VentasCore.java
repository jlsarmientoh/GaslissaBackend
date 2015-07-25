/**
 * 
 */
package co.com.gaslissa.core.cierre;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.common.enums.EstadoCliente;
import co.com.gaslissa.core.exception.CierreTurnoException;
import co.com.gaslissa.core.exception.CoreException;
import co.com.gaslissa.expo.config.repository.CierreVentaRepository;
import co.com.gaslissa.expo.config.repository.VentaRepository;
import co.com.gaslissa.servipunto.entity.Empleado;
import co.com.gaslissa.servipunto.entity.ViewVenta;
import co.com.gaslissa.servipunto.repository.EmpleadoRepository;
import co.com.gaslissa.servipunto.repository.ViewProductoTurnoRepository;
import co.com.gaslissa.servipunto.repository.ViewVentaRepository;

/**
 * @author Jorge
 *
 */
public class VentasCore {
	
	final static Logger logger = LoggerFactory.getLogger(VentasCore.class);
	
	private String[] gruposIsla;
	
	private final VentaRepository ventaRepository;
	
	private final ViewVentaRepository viewVentaRepository;
	
	private final EmpleadoRepository empleadoRepository;
	
	private final CierreVentaRepository cierreVentaRepository;
	
	private final ViewProductoTurnoRepository viewProductoTurnoRepository;

	
	public VentasCore(
			VentaRepository ventaRepository, 
			ViewVentaRepository viewVentaRepository,
			EmpleadoRepository empleadoRepository,
			CierreVentaRepository cierreVentaRepository,
			ViewProductoTurnoRepository viewProductoTurnoRepository) {
		super();
		this.ventaRepository = ventaRepository;
		this.viewVentaRepository = viewVentaRepository;
		this.empleadoRepository = empleadoRepository;
		this.cierreVentaRepository = cierreVentaRepository;
		this.viewProductoTurnoRepository = viewProductoTurnoRepository;
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
	public List<ViewVenta> consultarVentasFidelizados(
			long codEmp,
			Date desde,
			Date hasta,
			int isla,
			long turno) throws CierreTurnoException{
		try{
			List<ViewVenta> ventas = null;
			int i = isla - 1;
			String islas = this.gruposIsla[i];
	         
			ventas = this.viewVentaRepository.consultarVentasFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, (short)turno, islas, Long.toString(codEmp));
			
			for(ViewVenta venta : ventas){
				venta.setIsla(isla);
			}
			
			return ventas;
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de ventas fidelizadas: " + e.getMessage(), e);
			throw new CierreTurnoException("No se puede realizar la consulta de ventas fidelizadas: " + e.getMessage());
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
	 * @throws CierreTurnoException
	 */
	public List<ViewVenta> consultarVentasNoFidelizados(
			long codEmp,
			Date desde,
			Date hasta,
			int isla,
			long turno) throws CierreTurnoException{
		try{
			List<ViewVenta> ventas;
	        int i = isla - 1;
	        String islas = this.gruposIsla[i];
         
			ventas = this.viewVentaRepository.consultarVentasNoFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, (short)turno, islas, Long.toString(codEmp));
			
			for(ViewVenta venta : ventas){
				venta.setIsla(isla);
			}
			
			return ventas;
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage(), e);
			throw new CierreTurnoException("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage());
		}
	}
	
	/**
	 * Trae la lista de todos los empleados en el BD de servipunto
	 * @return
	 * @throws CierreTurnoException
	 */
	List<Empleado> getEmpleados() throws CierreTurnoException{
		try{
			return (List<Empleado>) this.empleadoRepository.findAll();
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de empelados en la bd servipunto: " + e.getMessage(), e);
			throw new CierreTurnoException("No se puede realizar la consulta de empelados en la bd servipunto: " + e.getMessage());
		}
	}
	
	/**
	 * Revisa si ya existe un cierre para los parámetros dados.
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
        	int i = 0;
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
	 * Retorna el total de las ventas fidelizadas de acuerdo a
	 * los parámetros dados
	 * @param codEmpleado
	 * @param turno
	 * @param isla
	 * @param desde
	 * @param hasta
	 * @return
	 * @throws CierreTurnoException
	 */
	public double consultarTotalVentasFidelizadas(
			long codEmpleado, 
			int turno, 
			int isla, 
			Date desde, 
			Date hasta) throws CierreTurnoException {
        try{   
            int i = isla - 1;
            String islas = this.gruposIsla[i];

            return this.viewVentaRepository.consultarTotalVentasFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, turno, islas, Long.toString(codEmpleado));                
        }catch (Exception ex){
        	logger.error("No se puede calcular el total de las ventas fidelizadas desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CierreTurnoException("No se puede calcular el total de las ventas fidelizadas desde la base de datos Servipunto: " + ex.getMessage());
        }
    }
	
	/**
	 * Retorna el total en cosumo de combustible de acuerdo con los
	 * parámetros dados
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CierreTurnoException
	 */
	public double consultarTotalProductosTurno(
			Date desde, 
			Date hasta, 
			int isla, 
			int turno) throws CierreTurnoException {
		try{   
            int i = isla - 1;
            String islas = this.gruposIsla[i];

            return this.viewProductoTurnoRepository.consultarTotalProductosTurno(desde, hasta, turno, islas);       
        }catch (Exception ex){
        	logger.error("No se puede calcular el total de los consumos de combustible desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CierreTurnoException("No se puede calcular el total de los consumos de combustible desde la base de datos Servipunto: " + ex.getMessage());
        }
	}
	
	/**
	 * Retorna la información de un ticket en particular 
	 * y para un turno en específico
	 * @param nroTiquete
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CierreTurnoException
	 */
	public ViewVenta consultarVentaTurno(
			long nroTiquete, 
			Date desde, 
			Date hasta, 
			int isla, 
			int turno) throws CierreTurnoException{
		try{   
            int i = isla - 1;
            String islas = this.gruposIsla[i];

            return this.viewVentaRepository.consultarVentasByTiqueteTurno(nroTiquete, desde, hasta, turno, islas);       
        }catch (Exception ex){
        	logger.error("No se puede obtener información del ticket # "+ nroTiquete + " desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CierreTurnoException("No se puede obtener información del ticket # "+ nroTiquete + " desde la base de datos Servipunto: " + ex.getMessage());
        }
	}
	
	/**
	 * Realizar las operaciones de registro de un cierre
	 * @param cierre
	 * @return
	 * @throws CierreTurnoException
	 */
	public long guardarCierre(CierreTurno cierre) throws CierreTurnoException{
		//TODO añadir soporte a transaccionalidad
		//TODO guardar el cierre
		//TODO guardar los medios de pago
		//TODO guardar las ventas
		//TODO consultar y guardar los consumos de combustible
		try{
			return 1l;
		}catch(Exception ex){
			logger.error("No se pudo realizar el cierre: " + ex.getMessage(), ex);
			throw new CierreTurnoException("No se pudo realizar el cierre: " + ex.getMessage());
		}
	}
}
