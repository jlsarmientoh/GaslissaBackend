package co.com.gaslissa.servipunto.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.servipunto.config.ServipuntoConfig;
import co.com.gaslissa.servipunto.core.venta.VentasCore;
import co.com.gaslissa.servipunto.repository.EmpleadoRepository;
import co.com.gaslissa.servipunto.repository.ViewProductoTurnoRepository;
import co.com.gaslissa.servipunto.repository.ViewVentaRepository;

@Configuration
@Import({ServipuntoConfig.class})
public class CoreConfig {
	
	@Bean
	@Autowired
	public VentasCore createVentasCore(
			ViewProductoTurnoRepository viewProductoTurnoRepository, 
			EmpleadoRepository empleadoRepository, 
			ViewVentaRepository viewVentaRepository) throws Exception{
		return new VentasCore(
				viewVentaRepository, 
				empleadoRepository,  
				viewProductoTurnoRepository);
	}
}
