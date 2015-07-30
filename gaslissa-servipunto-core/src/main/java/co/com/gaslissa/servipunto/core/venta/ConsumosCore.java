package co.com.gaslissa.servipunto.core.venta;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.servipunto.core.exception.CoreException;
import co.com.gaslissa.servipunto.core.util.CoreUtil;
import co.com.gaslissa.servipunto.repository.ViewProductoTurnoRepository;

public class ConsumosCore {
	
	final static Logger logger = LoggerFactory.getLogger(ConsumosCore.class);
	
	private final String[] gruposIsla;
	
	private final ViewProductoTurnoRepository viewProductoTurnoRepository;
	
	
	
	public ConsumosCore(String[] gruposIsla,
			ViewProductoTurnoRepository viewProductoTurnoRepository) {
		super();
		this.gruposIsla = gruposIsla;
		this.viewProductoTurnoRepository = viewProductoTurnoRepository;
	}


	/**
	 * Retorna el total en cosumo de combustible de acuerdo con los
	 * par�metros dados
	 * @param desde
	 * @param hasta
	 * @param isla
	 * @param turno
	 * @return
	 * @throws CoreException
	 */
	public double consultarTotalProductosTurno(
			Date desde, 
			Date hasta, 
			int isla, 
			int turno) throws CoreException {
		try{
            return this.viewProductoTurnoRepository.consultarTotalProductosTurno(desde, hasta, turno, CoreUtil.getIslas(isla, gruposIsla));       
        }catch (Exception ex){
        	logger.error("No se puede calcular el total de los consumos de combustible desde la base de datos Servipunto: " + ex.getMessage(), ex);
            throw new CoreException("No se puede calcular el total de los consumos de combustible desde la base de datos Servipunto: " + ex.getMessage());
        }
	}

}
