/**
 * 
 */
package co.com.gaslissa.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.core.config.CoreConfig;

/**
 * @author Jorge
 *
 */
@Configuration
@Import({CoreConfig.class})
public class ApplicationConfig {
	
	@Value("${server.port}")
	private int port;
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(port);
	    return factory;
	}



}
