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
import co.com.gaslissa.core.cierre.VentasCore;
import co.com.gaslissa.core.exception.CierreTurnoException;

/**
 * @author Jorge
 *
 */
@RestController
@RequestMapping("/cierres")
public class VentaResource {
	
	final static Logger logger = LoggerFactory.getLogger(VentaResource.class);
	
	private final VentasCore ventasCore;

	@Autowired
	public VentaResource(VentasCore ventasCore) {
		super();
		this.ventasCore = ventasCore;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Long> guardarCierre(
			@RequestBody CierreTurno input){
		try {
			Long numCierre = ventasCore.guardarCierre(input);
			return new ResponseEntity<Long>(numCierre, HttpStatus.OK);
		} catch (CierreTurnoException ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
