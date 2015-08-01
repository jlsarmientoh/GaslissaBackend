package co.com.gaslissa.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.core.cierre.CierreCore;
import co.com.gaslissa.core.cierre.ModoPagoCore;
import co.com.gaslissa.core.cliente.ClientesExpoCore;
import co.com.gaslissa.core.usuario.UsuarioCore;
import co.com.gaslissa.expo.config.ExpoConfig;
import co.com.gaslissa.expo.repository.CierreVentaRepository;
import co.com.gaslissa.expo.repository.ClienteRepository;
import co.com.gaslissa.expo.repository.ModoPagoRepository;
import co.com.gaslissa.expo.repository.UsuarioRespository;
import co.com.gaslissa.expo.repository.VentaRepository;

@Configuration
@Import({ExpoConfig.class})
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
	public CierreCore createVentasCore(
			VentaRepository ventaRepository,  
			CierreVentaRepository cierreVentaRepository) throws Exception{
		return new CierreCore(
				ventaRepository, 
				cierreVentaRepository);
	}
	
	@Bean
	@Autowired
	public UsuarioCore createUsuarioCore(
			UsuarioRespository usuarioRepository) throws Exception{
		return new UsuarioCore(usuarioRepository);
	}
}
