package com.infrasofttech.omni.frontdesk.configuration;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.infrasofttech.omni.frontdesk")
@ComponentScan({ "com.infrasoft.omni.frondesk.business.*" })
@ComponentScan({ "com.infrasoft.omni.frontdesk.dto.*" })
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	Environment environment;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public DataSource getDataSource() {
		System.out.println(">>>>>>Start>>>>>>>>>>>>>>>>>>>>dataSource object>>>>>>>>>>>>>>>>>>>>>>>>>>");
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	    dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	    dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	    dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	    //dataSource.setImplicitCachingEnabled(true);
		//dataSource.setFastConnectionFailoverEnabled(true);
	    System.out.println(">>>>>>>>End>>>>>>>>>>>>>>>>>>dataSource object created>>>>>>>>>>>>>>>>>>>>>>>>>>");
	    return dataSource;
	}
	
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.infrasoft.omni.frontdesk.dto");
		//entityManagerFactoryBean.setJpaProperties(jpaProperties());
		return entityManagerFactoryBean;
	}
	
	
	@Bean
	@Autowired
	JpaTransactionManager txnManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>entityManagerFactory created>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return transactionManager;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


}
