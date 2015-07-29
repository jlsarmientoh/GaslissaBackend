/**
 * 
 */
package co.com.gaslissa.servipunto.core.venta;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.enums.EstadoCliente;
import co.com.gaslissa.servipunto.core.exception.CoreException;
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
	
	private final ViewVentaRepository viewVentaRepository;
	
	private final EmpleadoRepository empleadoRepository;
	
	private final ViewProductoTurnoRepository viewProductoTurnoRepository;

	
	public VentasCore(
			ViewVentaRepository viewVentaRepository,
			EmpleadoRepository empleadoRepository,
			ViewProductoTurnoRepository viewProductoTurnoRepository) {
		super();
		this.viewVentaRepository = viewVentaRepository;
		this.empleadoRepository = empleadoRepository;
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
			long turno) throws CoreException{
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
	public List<ViewVenta> consultarVentasNoFidelizados(
			long codEmp,
			Date desde,
			Date hasta,
			int isla,
			long turno) throws CoreException{
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
			throw new CoreException("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage());
		}
	}
	
	/**
	 * Trae la lista de todos los empleados en el BD de servipunto
	 * @return
	 * @throws CoreException
	 */
	List<Empleado> getEmpleados() throws CoreException{
		try{
			return (List<Empleado>) this.empleadoRepository.findAll();
		}catch(Exception e){
			logger.error("No se puede realizar la consulta de empelados en la bd servipunto: " + e.getMessage(), e);
			throw new CoreException("No se puede realizar la consulta de empelados en la bd servipunto: " + e.getMessage());
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
            int i = isla - 1;
            String islas = this.gruposIsla[i];

            return this.viewVentaRepository.consultarTotalVentasFidelizados(EstadoCliente.NO_FIDELIZADO.descripcion(), desde, hasta, turno, islas, Long.toString(codEmpleado));                
        }catch (Exception ex){
        	logger.error("No se puede calcular el total de las ventas fidelizadas desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede calcular el total de las ventas fidelizadas desde la base de datos Servipunto: " + ex.getMessage());
        }
    }
	
	/**
	 * Retorna el total en cosumo de combustible de acuerdo con los
	 * par�metros dados
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CoreException
	 */
	public double consultarTotalProductosTurno(
			Date desde, 
			Date hasta, 
			int isla, 
			int turno) throws CoreException {
		try{   
            int i = isla - 1;
            String islas = this.gruposIsla[i];

            return this.viewProductoTurnoRepository.consultarTotalProductosTurno(desde, hasta, turno, islas);       
        }catch (Exception ex){
        	logger.error("No se puede calcular el total de los consumos de combustible desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede calcular el total de los consumos de combustible desde la base de datos Servipunto: " + ex.getMessage());
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
	public ViewVenta consultarVentaTurno(
			long nroTiquete, 
			Date desde, 
			Date hasta, 
			int isla, 
			int turno) throws CoreException{
		try{   
            int i = isla - 1;
            String islas = this.gruposIsla[i];

            return this.viewVentaRepository.consultarVentasByTiqueteTurno(nroTiquete, desde, hasta, turno, islas);       
        }catch (Exception ex){
        	logger.error("No se puede obtener informaci�n del ticket # "+ nroTiquete + " desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede obtener informaci�n del ticket # "+ nroTiquete + " desde la base de datos Servipunto: " + ex.getMessage());
        }
	}
}
