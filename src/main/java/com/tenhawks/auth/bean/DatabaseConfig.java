package com.tenhawks.auth.bean;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Mukhtiar
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DatabaseConfig {


  public static EntityManagerFactory entityManagerFactory(final DataSource dataSource, final String packagesToScan) {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(Boolean.TRUE);
    vendorAdapter.setShowSql(Boolean.TRUE);
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan(packagesToScan);
    factory.setDataSource(dataSource);
    factory.afterPropertiesSet();
    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
    return factory.getObject();
  }

  public static DataSource dataSource(final String driverClassName, final String jdbcUrl, final String jdbcUser,
                                      final String jdbcPass) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(jdbcUrl);
    dataSource.setUsername(jdbcUser);
    dataSource.setPassword(jdbcPass);
    return dataSource;
  }
}
