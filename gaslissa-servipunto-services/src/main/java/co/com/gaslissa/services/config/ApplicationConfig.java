/**
 * 
 */
package co.com.gaslissa.services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.servipunto.core.config.CoreConfig;

/**
 * @author Jorge
 *
 */
@Configuration
@Import({CoreConfig.class})
public class ApplicationConfig {

}
