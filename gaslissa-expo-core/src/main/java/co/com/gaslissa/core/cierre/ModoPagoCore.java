/**
 * 
 */
package co.com.gaslissa.core.cierre;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.core.exception.ModosPagoException;
import co.com.gaslissa.expo.entity.ModoPago;
import co.com.gaslissa.expo.repository.ModoPagoRepository;

/**
 * @author Jorge
 *
 */
public class ModoPagoCore {
	
	final static Logger logger = LoggerFactory.getLogger(ModoPagoCore.class);
	
	private final ModoPagoRepository modoPagoRepository;

	
	public ModoPagoCore(ModoPagoRepository modoPagoRepository) {
		super();
		this.modoPagoRepository = modoPagoRepository;
	}
	
	/**
	 * Retorna los medios de pagos principales
	 * @return
	 * @throws ModosPagoException
	 */
	public List<ModoPago> consultarModosPagoPadre() throws ModosPagoException{
		try{
			return this.modoPagoRepository.consultarModosPagoPadre();
		}catch(Exception ex){
			logger.error("No se pudo obtener la información de medios de pago: " + ex.getMessage(), ex);
			throw new ModosPagoException("No se pudo obtener la información de medios de pago: " + ex.getMessage());
		}
	}
	
	/**
	 * Retorna los medios de pago hijos de un dado medio de pago padre
	 * @param idPadre
	 * @return
	 * @throws ModosPagoException
	 */
	public List<ModoPago> consultarModosPagoHijo(int idPadre) throws ModosPagoException{
		try{
			return this.modoPagoRepository.consultarModosPagoHijo(idPadre);
		}catch(Exception ex){
			logger.error("No se pudo obtener la información de medios de pago: " + ex.getMessage(), ex);
			throw new ModosPagoException("No se pudo obtener la información de medios de pago: " + ex.getMessage());
		}
	}
}
