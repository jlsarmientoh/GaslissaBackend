package co.com.gaslissa.servipunto.core.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.servipunto.config.ServipuntoConfig;
import co.com.gaslissa.servipunto.core.venta.ConsumosCore;
import co.com.gaslissa.servipunto.core.venta.EmpleadosCore;
import co.com.gaslissa.servipunto.core.venta.VentasCore;
import co.com.gaslissa.servipunto.repository.EmpleadoRepository;
import co.com.gaslissa.servipunto.repository.ViewProductoTurnoRepository;
import co.com.gaslissa.servipunto.repository.ViewVentaRepository;

@Configuration
@Import({ServipuntoConfig.class})
@EnableConfigurationProperties
public class CoreConfig {
	
	@Value("${servipunto.gruposIsla}")
	private List<String> gruposIsla;
	
	@Bean
	@Autowired
	public VentasCore createVentasCore(
			ViewVentaRepository viewVentaRepository) throws Exception{
		return new VentasCore(
				this.gruposIsla.toArray(new String[0]),
				viewVentaRepository);
	}
	
	@Bean
	@Autowired
	public EmpleadosCore createEmpleadosCore(EmpleadoRepository empleadoRepository) throws Exception{
		return new EmpleadosCore(empleadoRepository);
	}
	
	@Bean
	@Autowired
	public ConsumosCore createConsumosCore(
			ViewProductoTurnoRepository viewProductoTurnoRepository) throws Exception{
		return new ConsumosCore(this.gruposIsla.toArray(new String[0]),
				viewProductoTurnoRepository);
	}

	public List<String> getGruposIsla() {
		return gruposIsla;
	}

	public void setGruposIsla(List<String> gruposIsla) {
		this.gruposIsla = gruposIsla;
	}
}
