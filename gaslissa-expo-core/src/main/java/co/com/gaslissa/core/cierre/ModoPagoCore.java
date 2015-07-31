/**
 * 
 */
package co.com.gaslissa.core.cierre;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.dto.MedioDePago;
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
	public List<MedioDePago> consultarModosPagoPadre() throws ModosPagoException{
		try{
			List<MedioDePago> medios = null;
			List<ModoPago> modos = this.modoPagoRepository.consultarModosPagoPadre();
			
			if(modos !=null){
				medios = new ArrayList<MedioDePago>();
				for(ModoPago modo : modos){
					MedioDePago medio = new MedioDePago();
					medio.setNombre(modo.getNombre());
					medio.setId(modo.getIdModoPago());
					medio.setDetalle(modo.getDetalle());
					medios.add(medio);
				}
			}
			
			return medios;
		}catch(Exception ex){
			logger.error("No se pudo obtener la informaci�n de medios de pago: " + ex.getMessage(), ex);
			throw new ModosPagoException("No se pudo obtener la informaci�n de medios de pago: " + ex.getMessage());
		}
	}
	
	/**
	 * Retorna los medios de pago hijos de un dado medio de pago padre
	 * @param idPadre
	 * @return
	 * @throws ModosPagoException
	 */
	public List<MedioDePago> consultarModosPagoHijo(long idPadre) throws ModosPagoException{
		try{
			List<MedioDePago> medios = null;
			List<ModoPago> modos = this.modoPagoRepository.consultarModosPagoHijo(idPadre);
			
			if(modos !=null){
				medios = new ArrayList<MedioDePago>();
				for(ModoPago modo : modos){
					MedioDePago medio = new MedioDePago();
					medio.setNombre(modo.getNombre());
					medio.setId(modo.getIdModoPago());
					medio.setDetalle(modo.getDetalle());
					medios.add(medio);
				}
			}
			
			return medios;
		}catch(Exception ex){
			logger.error("No se pudo obtener la informaci�n de medios de pago: " + ex.getMessage(), ex);
			throw new ModosPagoException("No se pudo obtener la informaci�n de medios de pago: " + ex.getMessage());
		}
	}
}
