package com.rahul.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.rahul.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	// DataSource Bean is available 
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource=new BasicDataSource();
		
		//DataBase Connection Information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		return dataSource;
		
	}
	
	//SessionFectory Bean is available
	
	@Bean
	public SessionFactory getSessionFectory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.rahul.shoppingbackend.dto");
		return builder.buildSessionFactory();
		
	}

	
	//Hibernate Properties will be return in this method
	@Bean
	public Properties getHibernateProperties() {
		
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "create");
		
		return properties;
	}
	
	//TransactionManager Bean
	@Bean
	public HibernateTransactionManager getTransactionManger(SessionFactory sessionFectory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFectory);
		
		return transactionManager;
	}

}