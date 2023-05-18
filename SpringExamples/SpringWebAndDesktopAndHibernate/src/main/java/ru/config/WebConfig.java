package ru.config;

import java.io.IOException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "nsi.uer.wm")
@EnableTransactionManagement
public class WebConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public DataSource dataSource() {
		try {
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource) initialContext.lookup("jdbc/DataSourceName");
			return dataSource;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public SessionFactory sessionFactory() throws IOException {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"ru.test.model"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		// sessionFactory.setConfigLocations(context.getResource("classpath:hibernate.cfg.xml"));
		sessionFactory.afterPropertiesSet();
		return sessionFactory.getObject();
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		hibernateProperties.put("hibernate.format_sql", true);
		hibernateProperties.put("hibernate.use_sql_comments", true);
		hibernateProperties.put("hibernate.show-sql", true);
		hibernateProperties.put("hibernate.max_fetch_depth", 3);
		hibernateProperties.put("hibernate.jdbc.batch_size", 10);
		hibernateProperties.put("hibernate.jdbc.fetch_size", 50);

		// hibernateProperties.setProperty("hibernate.ddl-auto", "none");
		// hibernateProperties.setProperty("hibernate.current_session_context_class",
		// "org.springframework.orm.hibernate5.SpringSessionContext");

		return hibernateProperties;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory());
		return transactionManager;
	}
}
