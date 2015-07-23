/**
 * 
 */
package co.com.gaslissa.core.cierre;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import co.com.gaslissa.common.enums.EstadoCliente;
import co.com.gaslissa.core.exception.CierreTurnoException;
import co.com.gaslissa.core.exception.CoreException;
import co.com.gaslissa.expo.config.repository.VentaRepository;
import co.com.gaslissa.expo.entity.Venta;
import co.com.gaslissa.servipunto.entity.ViewVenta;
import co.com.gaslissa.servipunto.repository.ViewVentaRepository;

/**
 * @author Jorge
 *
 */
public class VentasCore {
	
	final static Logger logger = LoggerFactory.getLogger(VentasCore.class);
	
	@Value("${servipunto.ventas.islas}")
	private String[] gruposIsla;
	
	private final VentaRepository ventaRepository;
	
	private final ViewVentaRepository viewVentaRepository;

	
	public VentasCore(VentaRepository ventaRepository, ViewVentaRepository viewVentaRepository) {
		super();
		this.ventaRepository = ventaRepository;
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
			logger.error("No se puede realizar la consulta de ventas fidelizadas: " + e.getMessage());
			throw new CierreTurnoException("No se puede realizar la consulta de ventas fidelizadas: " + e.getMessage(), e);
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
			logger.error("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage());
			throw new CierreTurnoException("No se puede realizar la consulta de ventas no fidelizadas: " + e.getMessage(), e);
		}
	}
}
