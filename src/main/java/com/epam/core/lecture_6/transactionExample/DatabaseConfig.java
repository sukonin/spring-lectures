package com.epam.core.lecture_6.transactionExample;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.epam.core.lecture_6.transactionExample")
@EnableTransactionManagement
public class
DatabaseConfig {


  @Bean
  DataSource dataSource() {
    System.getProperties().put("derby.locks.waitTimeout", "1");
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.DERBY)
        .addScript("classpath:lecture_6/schema.sql")
        .build();
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }
}
