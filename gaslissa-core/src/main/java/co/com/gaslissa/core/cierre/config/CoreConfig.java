package co.com.gaslissa.core.cierre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.core.cierre.ClientesExpoCore;
import co.com.gaslissa.core.cierre.ModoPagoCore;
import co.com.gaslissa.core.cierre.VentasCore;
import co.com.gaslissa.expo.config.ExpoConfig;
import co.com.gaslissa.expo.repository.CierreVentaRepository;
import co.com.gaslissa.expo.repository.ClienteRepository;
import co.com.gaslissa.expo.repository.ModoPagoRepository;
import co.com.gaslissa.expo.repository.VentaRepository;
import co.com.gaslissa.servipunto.config.ServipuntoConfig;
import co.com.gaslissa.servipunto.repository.EmpleadoRepository;
import co.com.gaslissa.servipunto.repository.ViewProductoTurnoRepository;
import co.com.gaslissa.servipunto.repository.ViewVentaRepository;

@Configuration
@Import({ServipuntoConfig.class, ExpoConfig.class})
public class CoreConfig {

	@Bean
	@Autowired
	public ClientesExpoCore createClientesExpoCore(ClienteRepository clienteRepositoryExpo) throws Exception{
		return new ClientesExpoCore(clienteRepositoryExpo);
	}

	@Bean
	@Autowired
	public ModoPagoCore createModoPagoCore(ModoPagoRepository modoPagoRepository) throws Exception{
		return new ModoPagoCore(modoPagoRepository);
	}
	
	@Bean
	@Autowired
	public VentasCore createVentasCore(
			VentaRepository ventaRepository, 
			ViewProductoTurnoRepository viewProductoTurnoRepository, 
			EmpleadoRepository empleadoRepository, 
			CierreVentaRepository cierreVentaRepository, 
			ViewVentaRepository viewVentaRepository) throws Exception{
		return new VentasCore(
				ventaRepository, 
				viewVentaRepository, 
				empleadoRepository, 
				cierreVentaRepository, 
				viewProductoTurnoRepository);
	}
}
