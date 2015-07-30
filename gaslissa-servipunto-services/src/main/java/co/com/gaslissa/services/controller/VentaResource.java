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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.common.dto.ValeVenta;
import co.com.gaslissa.servipunto.core.venta.VentasCore;

/**
 * @author Jorge
 *
 */
@RestController
@RequestMapping("/servipunto")
public class VentaResource {
	
	final static Logger logger = LoggerFactory.getLogger(VentaResource.class);
	
	private final VentasCore ventasCore;

	@Autowired
	public VentaResource(VentasCore ventasCore) {
		super();
		this.ventasCore = ventasCore;
	}
	
	@RequestMapping(value = "/ventas", method = RequestMethod.POST)
	public ResponseEntity<List<ValeVenta>> guardarCierre(
			@RequestBody CierreTurno input){
		try {
			List<ValeVenta> ventas = ventasCore.consultarVentasFidelizados(input.getEmpleado(), input.getFecha(), input.getFecha(), input.getIsla(), input.getTurno());
			return new ResponseEntity<List<ValeVenta>>(ventas, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<List<ValeVenta>>(new ArrayList<ValeVenta>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
