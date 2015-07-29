package co.com.gaslissa.core.cierre;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.core.exception.CierreTurnoException;
import co.com.gaslissa.expo.repository.CierreVentaRepository;
import co.com.gaslissa.expo.repository.VentaRepository;

public class CierreCore {
	
	final static Logger logger = LoggerFactory.getLogger(CierreCore.class);
	
	private final VentaRepository ventaRepository;
	
	private final CierreVentaRepository cierreVentaRepository;
	
	
	public CierreCore(VentaRepository ventaRepository, CierreVentaRepository cierreVentaRepository) {
		super();
		this.ventaRepository = ventaRepository;
		this.cierreVentaRepository = cierreVentaRepository;
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
	 * Realizar las operaciones de registro de un cierre
	 * @param cierre
	 * @return
	 * @throws CierreTurnoException
	 */
	public long guardarCierre(CierreTurno cierre) throws CierreTurnoException{
		//TODO a�adir soporte a transaccionalidad
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
