/**
 * 
 */
package co.com.gaslissa.expo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jorge
 *
 */
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
public class ExpoConfig {
	
	@Value("${expo.driver}")
	private String driver;
	
	@Value("${expo.url}")
	private String url;
	
	@Value("${expo.user}")
	private String user;
	
	@Value("${expo.pwd}")
	private String pwd;
	
	@Bean(name = "expoDatasource")
	public DataSource datasource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);
		
		return dataSource;
	}
	
	@Bean(name="expoEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManager(
			@Qualifier("expoDatasource") DataSource datasource
			){
		LocalContainerEntityManagerFactoryBean entityManagerFacotry = new LocalContainerEntityManagerFactoryBean();
		entityManagerFacotry.setDataSource(datasource);
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);
		
		entityManagerFacotry.setJpaVendorAdapter(jpaVendorAdapter);
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "");
		
		entityManagerFacotry.setJpaProperties(jpaProperties);
		entityManagerFacotry.setPackagesToScan("co.com.gaslissa.expo.entity");
		entityManagerFacotry.getJpaPropertyMap().put("jadira.usertype.autoRegisterUserTypes", "true");
		
		return entityManagerFacotry;
	}
	
	@Bean(name= "expoTransactionManager")
	public JpaTransactionManager transactionManager(
			@Qualifier("expoEntityManager") LocalContainerEntityManagerFactoryBean entityManager,
			@Qualifier("expoDatasource") DataSource datasource
			){
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManager.getObject());
		transactionManager.setDataSource(datasource);
		
		return transactionManager;
	}
	
	@Bean(name = "expoSessionFactory")
	public HibernateJpaSessionFactoryBean sessionFactory(
			@Qualifier("expoEntityManager") LocalContainerEntityManagerFactoryBean entityManager
			){
		HibernateJpaSessionFactoryBean sessionFactory = new HibernateJpaSessionFactoryBean();
		sessionFactory.setEntityManagerFactory(entityManager.getObject());
		
		return sessionFactory;
	}

}
