package com.tenhawks.auth;

import com.tenhawks.auth.bean.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * @author Mukhtiar
 */
@SpringBootApplication
@EnableGlobalMethodSecurity (prePostEnabled = true)
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.tenhawks.auth")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		return DatabaseConfig.dataSource(environment.getProperty("jdbc.driverClassName"),
				environment.getProperty("jdbc.url"), environment.getProperty("jdbc.user"), environment.getProperty("jdbc" +
						".pass"));
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return DatabaseConfig.entityManagerFactory(dataSource(), "com.tenhawks.auth");
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
	
}
