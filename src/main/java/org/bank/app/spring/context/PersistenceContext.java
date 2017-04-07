package org.bank.app.spring.context;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceContext {

	@Bean(destroyMethod = "close")
	public DataSource dataSource(Environment environment) {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(environment.getProperty("db.driver"));
		config.setJdbcUrl(environment.getProperty("db.url"));
		config.setUsername(environment.getProperty("db.username"));
		config.setPassword(environment.getProperty("db.password"));
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource, Environment environment){
		return null;
		
	}
}
