package com.epam.core.lecture_7.jpaExample.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.epam.core.lecture_7.jpaExample")
@EnableJpaRepositories(basePackages = "com.epam.core.lecture_7.jpaExample.springDataJpaRepository")
public class AppConfig {

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean
        factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setPersistenceUnitManager(persistenceUnitManager());
    factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    factoryBean.setJpaProperties(hibernateProperties());
    factoryBean.afterPropertiesSet();
    return factoryBean.getNativeEntityManagerFactory();
  }

  @Bean
  public PersistenceUnitManager persistenceUnitManager() {
    DefaultPersistenceUnitManager
        persistenceUnitManager = new DefaultPersistenceUnitManager();
    persistenceUnitManager.setPackagesToScan("com.epam.core.lecture_7.jpaExample.domain");
    persistenceUnitManager.setDefaultDataSource(dataSource());
    return persistenceUnitManager;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JpaTransactionManager(entityManagerFactory());
  }

  @Bean
  public DataSource dataSource() {
    EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .build();
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setDataSource(embeddedDatabase);
    hikariDataSource.setMaximumPoolSize(5);
    hikariDataSource.setConnectionTestQuery("select 1");
    return hikariDataSource;
  }

  @Bean
  public Properties hibernateProperties() {
    Properties hibernateProp = new Properties();
    hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
    hibernateProp.put("hibernate.format_sql", true);
    hibernateProp.put("hibernate.use_sql_comments", true);
    hibernateProp.put("hibernate.show_sql", true);
    return hibernateProp;
  }
}
