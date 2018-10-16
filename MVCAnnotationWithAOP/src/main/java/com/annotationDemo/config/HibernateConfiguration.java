package com.annotationDemo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.annotationDemo.config")
public class HibernateConfiguration {
	
	Properties jpaProperties;
	
/*	public HibernateConfiguration() {
		jpaProperties = new Properties();
		BasicDataSource dataSource = new BasicDataSource();
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	}*/
	
	@Bean
	public DataSource dataSource(){
		 BasicDataSource dataSource = new BasicDataSource();
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/sample");
		 dataSource.setUsername("root");
		 dataSource.setPassword("root");
		 return dataSource;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.annotationDemo.model");
		
		Properties jpaProperties = new Properties();
		
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("hibernate.format_sql","hibernate.format_sql");
		
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		
		return entityManagerFactoryBean;
	}
	
	@Bean
   public PlatformTransactionManager getPlatformTransactionManager(EntityManagerFactory entityManagerFactoryBean){
		
	JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactoryBean);
	return jpaTransactionManager;
		
		
		
	}

}
