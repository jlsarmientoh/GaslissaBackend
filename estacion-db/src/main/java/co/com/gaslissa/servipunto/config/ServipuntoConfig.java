/**
 * 
 */
package co.com.gaslissa.servipunto.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@EnableJpaRepositories(
		entityManagerFactoryRef = "servipuntoEntityManager",
		transactionManagerRef = "servipuntoTransactionManager",
		basePackages = {"co.com.gaslissa.servipunto.repository"}
		)
public class ServipuntoConfig {
	
	@Value("${servipunto.driver}")
	private String driver;
	
	@Value("${servipunto.url}")
	private String url;
	
	@Value("${servipunto.user}")
	private String user;
	
	@Value("${servipunto.pwd}")
	private String pwd;

	@Bean(name = "servipuntoDatasource")
	public DataSource datasource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);
		
		return dataSource;
	}
	
	@Bean(name="servipuntoEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManager(
			@Qualifier("servipuntoDatasource") DataSource datasource
			){
		LocalContainerEntityManagerFactoryBean entityManagerFacotry = new LocalContainerEntityManagerFactoryBean();
		entityManagerFacotry.setDataSource(datasource);
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(false);
		jpaVendorAdapter.setShowSql(true);
		
		entityManagerFacotry.setJpaVendorAdapter(jpaVendorAdapter);
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "");
		
		entityManagerFacotry.setJpaProperties(jpaProperties);
		entityManagerFacotry.setPackagesToScan("co.com.gaslissa.servipunto.entity");
		entityManagerFacotry.getJpaPropertyMap().put("jadira.usertype.autoRegisterUserTypes", "true");
		
		return entityManagerFacotry;
	}
	
	@Bean(name= "servipuntoTransactionManager")
	public JpaTransactionManager transactionManager(
			@Qualifier("servipuntoEntityManager") LocalContainerEntityManagerFactoryBean entityManager,
			@Qualifier("servipuntoDatasource") DataSource datasource
			){
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManager.getObject());
		transactionManager.setDataSource(datasource);
		
		return transactionManager;
	}
	
	@Bean(name = "servipuntoSessionFactory")
	public HibernateJpaSessionFactoryBean sessionFactory(
			@Qualifier("servipuntoEntityManager") LocalContainerEntityManagerFactoryBean entityManager
			){
		HibernateJpaSessionFactoryBean sessionFactory = new HibernateJpaSessionFactoryBean();
		sessionFactory.setEntityManagerFactory(entityManager.getObject());
		
		return sessionFactory;
	}
}
