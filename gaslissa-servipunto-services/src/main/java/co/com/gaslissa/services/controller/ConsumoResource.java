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
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.CierreTurno;
import co.com.gaslissa.common.dto.Consumo;
import co.com.gaslissa.servipunto.core.exception.CoreException;
import co.com.gaslissa.servipunto.core.venta.ConsumosCore;

@RestController
@RequestMapping("/servipunto/consumos")
public class ConsumoResource {
	
	final static Logger logger = LoggerFactory.getLogger(ConsumoResource.class);
	
	private final ConsumosCore consumoCore;

	@Autowired
	public ConsumoResource(ConsumosCore consumoCore) {
		super();
		this.consumoCore = consumoCore;
	}
	
	@RequestMapping(value = "/turno/total", method = RequestMethod.POST)
	public ResponseEntity<Double> getTotalProductosTurno(
			@RequestBody CierreTurno input){
		try {
			Double total = consumoCore.consultarTotalProductosTurno(input.getFecha(), input.getFecha(), input.getIsla(), input.getTurno());
			
			if(total == null){
				return new ResponseEntity<Double>(total, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<Double>(total, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación consultar el total de consumos.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<Double>(new Double(0), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/turno", method = RequestMethod.POST)
	public ResponseEntity<List<Consumo>> getProductosTurno(
			@RequestBody CierreTurno input){
		try{
			List<Consumo> consumos = consumoCore.consultarConsumosTurno(input.getFecha(), input.getFecha(), input.getIsla(), input.getTurno());
			
			if(consumos == null || consumos.isEmpty()){
				return new ResponseEntity<List<Consumo>>(consumos, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<List<Consumo>>(consumos, HttpStatus.OK);
			}
		} catch (CoreException ex) {
			logger.error("No se puede realizar la operación consultar el los consumos del turno.  Por favor revise los datos del cierre y vuelva a intentarlo." + ex.getMessage());
			return new ResponseEntity<List<Consumo>>(new ArrayList<Consumo>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
