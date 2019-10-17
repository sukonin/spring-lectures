package com.epam.core.lecture_5.jdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan("com.epam.core.lecture_5.jdbcTemplate")
@PropertySource("classpath:/lecture_5/db.properties")
public class HikariDatabaseConfig {

  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;

  @Bean
  public DataSource hikariDatasource() {
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setJdbcUrl(url);
    hikariDataSource.setUsername(username);
    hikariDataSource.setPassword(password);
    hikariDataSource.setMaximumPoolSize(10);
    return hikariDataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(hikariDatasource());
  }
}
