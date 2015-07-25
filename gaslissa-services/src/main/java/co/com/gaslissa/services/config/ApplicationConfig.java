/**
 * 
 */
package co.com.gaslissa.services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import co.com.gaslissa.core.cierre.config.CoreConfig;
import co.com.gaslissa.expo.config.ExpoConfig;
import co.com.gaslissa.servipunto.config.ServipuntoConfig;

/**
 * @author Jorge
 *
 */
@Configuration
@Import({ServipuntoConfig.class, ExpoConfig.class, CoreConfig.class})
public class ApplicationConfig {

}
