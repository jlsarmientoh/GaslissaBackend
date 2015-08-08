/**
 * 
 */
package co.com.gaslissa.services.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.common.dto.ValeVenta;
import co.com.gaslissa.servipunto.core.exception.CoreException;
import co.com.gaslissa.servipunto.core.venta.VentasCore;

/**
 * @author Jorge
 *
 */
@RestController
@RequestMapping("/servipunto/ventas")
public class VentaResource {
	
	final static Logger logger = LoggerFactory.getLogger(VentaResource.class);
	
	private final VentasCore ventasCore;

	@Autowired
	public VentaResource(VentasCore ventasCore) {
		super();
		this.ventasCore = ventasCore;
	}
	
	@RequestMapping(value = "/fidelizados/turno", method = RequestMethod.POST)
	public ResponseEntity<List<ValeVenta>> getVentasFidelizados(
			@RequestBody CierreTurno input){
		try {
			List<ValeVenta> ventas = ventasCore.consultarVentasFidelizados(input.getEmpleado(), input.getFecha(), input.getFecha(), input.getIsla(), input.getTurno());
			
			if(ventas == null || ventas.isEmpty()){
				return new ResponseEntity<List<ValeVenta>>(ventas, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<ValeVenta>>(ventas, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<List<ValeVenta>>(new ArrayList<ValeVenta>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/fidelizados/turno/total", method = RequestMethod.POST)
	public ResponseEntity<Double> getTotalVentasFidelizados(
			@RequestBody CierreTurno input){
		try {
			Double total = ventasCore.consultarTotalVentasFidelizadas(input.getEmpleado(), input.getTurno(), input.getIsla(), input.getFecha(), input.getFecha());
			
			if(total == null){
				return new ResponseEntity<Double>(total, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<Double>(total, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<Double>(new Double(0), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/nofidelizados/turno", method = RequestMethod.POST)
	public ResponseEntity<List<ValeVenta>> getVentasNoFidelizados(
			@RequestBody CierreTurno input){
		try {
			List<ValeVenta> ventas = ventasCore.consultarVentasNoFidelizados(input.getEmpleado(), input.getFecha(), input.getFecha(), input.getIsla(), input.getTurno());
			
			if(ventas == null || ventas.isEmpty()){
				return new ResponseEntity<List<ValeVenta>>(ventas, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<ValeVenta>>(ventas, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<List<ValeVenta>>(new ArrayList<ValeVenta>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/nofidelizados/turno/total", method = RequestMethod.POST)
	public ResponseEntity<Double> getTotalVentasNoFidelizados(
			@RequestBody CierreTurno input){
		try {
			Double total = ventasCore.consultarTotalVentasNoFidelizadas(input.getEmpleado(), input.getTurno(), input.getIsla(), input.getFecha(), input.getFecha());
			
			if(total == null){
				return new ResponseEntity<Double>(total, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<Double>(total, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<Double>(new Double(0), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ValeVenta> getValeById(@PathVariable long id){
		try{
			ValeVenta venta = ventasCore.consultarVenta(id);
			if(venta == null){
				return new ResponseEntity<ValeVenta>(venta, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<ValeVenta>(venta, HttpStatus.OK);
			}
		}catch(CoreException ex){
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<ValeVenta>(new ValeVenta(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@RequestMapping(value = "/vale", method = RequestMethod.POST)
	public ResponseEntity<ValeVenta> getValeById(@RequestBody ValeVenta vale){
		try{
			ValeVenta venta = ventasCore.consultarVentaTurno(vale.getTiquete_Nro(), vale.getFecha(), vale.getFecha(), vale.getIsla(), vale.getTurno());
			if(venta == null){
				return new ResponseEntity<ValeVenta>(venta, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<ValeVenta>(venta, HttpStatus.OK);
			}
		}catch(CoreException ex){
			logger.error("No se puede realizar la operación de guardar cierre.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<ValeVenta>(new ValeVenta(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
