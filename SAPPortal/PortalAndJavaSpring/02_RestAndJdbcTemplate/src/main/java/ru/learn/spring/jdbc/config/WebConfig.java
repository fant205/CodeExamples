package ru.learn.spring.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "ru.learn.spring.jdbc")
@EnableTransactionManagement
public class WebConfig {

    @Bean
    public DataSource dataSource() {
        try {
            InitialContext initialContext = new InitialContext();

            //there you should give initialContext jdbc data source name
            //that you have created on SAP Portal in
            //1. Go to Configuration - Infrastructure - Application Resources
            //2. Push Create new resource - New JDBC Custom DataSource and create new data source
            DataSource dataSource = (DataSource) initialContext.lookup("jdbc/MyCustomDataSource");
            return dataSource;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}