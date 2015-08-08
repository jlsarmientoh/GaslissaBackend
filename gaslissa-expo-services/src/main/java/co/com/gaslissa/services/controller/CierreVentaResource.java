/**
 * 
 */
package co.com.gaslissa.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.core.cierre.CierreCore;
import co.com.gaslissa.core.exception.CierreTurnoException;

/**
 * @author Jorge
 *
 */
@RestController
@RequestMapping("/gaslissa/cierre/ventas")
public class CierreVentaResource {

	final static Logger logger = LoggerFactory.getLogger(CierreVentaResource.class);
	
	private final CierreCore cierreCore;

	/**
	 * @param cierreCore
	 */
	@Autowired
	public CierreVentaResource(CierreCore cierreCore) {
		super();
		this.cierreCore = cierreCore;
	}
	
	@RequestMapping(value = "/existe", method = RequestMethod.POST)
	public ResponseEntity<Boolean> existeCierre(
			@RequestBody CierreTurno input){
		try{
			return new ResponseEntity<Boolean>(this.cierreCore.existeCierre(input.getEmpleado(), input.getTurno(), input.getIsla(), input.getFecha(), input.getFecha()), HttpStatus.OK);
		}catch(CierreTurnoException ex){
			logger.error("No se puedeconsultar si el cierre ya existe.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity<Long> guardarCierre(
			@RequestBody CierreTurno input){
		try{
			return new ResponseEntity<Long>(this.cierreCore.guardarCierre(input), HttpStatus.OK);
		}catch(CierreTurnoException ex){
			logger.error("No se puedeconsultar si el cierre ya existe.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<Long>(0l, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
