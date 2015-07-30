package co.com.gaslissa.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.Islero;
import co.com.gaslissa.servipunto.core.exception.CoreException;
import co.com.gaslissa.servipunto.core.venta.EmpleadosCore;

@RestController
@RequestMapping("/servipunto/empleados")
public class EmpleadoResource {
	
	final static Logger logger = LoggerFactory.getLogger(EmpleadoResource.class);
	
	
	private final EmpleadosCore empleadosCore;
	
	
	/**
	 * 
	 * @param empleadosCore
	 */
	@Autowired
	public EmpleadoResource(EmpleadosCore empleadosCore) {
		super();
		this.empleadosCore = empleadosCore;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Islero>> getVentasNoFidelizados(){
		try {
			List<Islero> isleros = empleadosCore.getEmpleados();
			
			if(isleros == null || isleros.isEmpty()){
				return new ResponseEntity<List<Islero>>(isleros, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<Islero>>(isleros, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<List<Islero>>(new ArrayList<Islero>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
