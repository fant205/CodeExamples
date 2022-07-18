package ru.config;

import java.sql.Driver;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@ComponentScan(basePackages = "ru.test")
@EnableTransactionManagement
public class DesktopConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws NamingException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "ru.test.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
//		sessionFactory.setAnnotatedClasses(Material.class, Uer.class);
		// sessionFactory.setConfigLocations(context.getResource("classpath:hibernate.cfg.xml"));

//		org.hibernate.boot.model.naming.ImplicitNamingStrategy

		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() throws NamingException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		hibernateProperties.put("hibernate.format_sql", true);
		hibernateProperties.put("hibernate.use_sql_comments", true);
		hibernateProperties.put("hibernate.show-sql", true);
		hibernateProperties.put("hibernate.max_fetch_depth", 1);
		hibernateProperties.put("hibernate.jdbc.batch_size", 1);
		hibernateProperties.put("hibernate.jdbc.fetch_size", 1);


		return hibernateProperties;
	}

	
	
	@Bean
	public DataSource dataSource() {
		try {
			SimpleDriverDataSource ds = new SimpleDriverDataSource();
			Class<? extends Driver> driver = (Class<? extends Driver>) Class
					.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ds.setDriverClass(driver);

//			SingleConnectionDataSource ds = new SingleConnectionDataSource();
			ds.setUrl("jdbc:sqlserver://host:port;databaseName=dbname");
			ds.setUsername("user");
			ds.setPassword("password");

			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
