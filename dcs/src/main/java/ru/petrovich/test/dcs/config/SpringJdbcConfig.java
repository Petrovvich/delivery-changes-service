package ru.petrovich.test.dcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dcs");
        dataSource.setUsername("dcs");
        dataSource.setPassword("dcs");

        Properties properties = new Properties();
        properties.setProperty("serverTimezone", "UTC");

        dataSource.setConnectionProperties(properties);

        return dataSource;
    }
}
