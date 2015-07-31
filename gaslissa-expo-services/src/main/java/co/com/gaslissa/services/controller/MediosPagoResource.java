/**
 * 
 */
package co.com.gaslissa.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.MedioDePago;
import co.com.gaslissa.core.cierre.ModoPagoCore;
import co.com.gaslissa.core.exception.ModosPagoException;

/**
 * @author Jorge
 *
 */
@RestController
@RequestMapping("/gaslissa/medios")
public class MediosPagoResource {

	final static Logger logger = LoggerFactory.getLogger(MediosPagoResource.class);
	
	private final ModoPagoCore modoPagoCore;

	/**
	 * @param modoPagoCore
	 */
	@Autowired
	public MediosPagoResource(ModoPagoCore modoPagoCore) {
		super();
		this.modoPagoCore = modoPagoCore;
	}
	
	
	@RequestMapping(value = "/padres", method = RequestMethod.GET)
	public ResponseEntity<List<MedioDePago>> getMediosPadre(){
		try{
			List<MedioDePago> medios = modoPagoCore.consultarModosPagoPadre();
			
			if(medios == null || medios.isEmpty()){
				return new ResponseEntity<List<MedioDePago>>(medios, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<MedioDePago>>(medios, HttpStatus.OK);
			}
		}catch(ModosPagoException ex){
			logger.error("No se pueden consultar los medios de pago padre." + ex.getMessage());
			return new ResponseEntity<List<MedioDePago>>(new ArrayList<MedioDePago>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/hijos/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<MedioDePago>> getMediosHijo(@PathVariable long id){
		try{
			List<MedioDePago> medios = modoPagoCore.consultarModosPagoHijo(id);
			
			if(medios == null || medios.isEmpty()){
				return new ResponseEntity<List<MedioDePago>>(medios, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<MedioDePago>>(medios, HttpStatus.OK);
			}
		}catch(ModosPagoException ex){
			logger.error("No se pueden consultar los medios de pago hijo." + ex.getMessage());
			return new ResponseEntity<List<MedioDePago>>(new ArrayList<MedioDePago>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
