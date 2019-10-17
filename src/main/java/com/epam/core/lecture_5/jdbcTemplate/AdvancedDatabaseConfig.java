package com.epam.core.lecture_5.jdbcTemplate;

import javax.sql.DataSource;
import org.h2.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@ComponentScan("com.epam.core.lecture_5.jdbcTemplate")
@PropertySource("classpath:/lecture_5/db.properties")
public class AdvancedDatabaseConfig {

  @Value("${url}")
  private String url;
  @Value("${username}")
  private String username;
  @Value("${password}")
  private String password;

  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriver(new Driver());
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
    return dataSource;
  }

  @Value("classpath:/lecture_5/schema.sql")
  private Resource schemaScript;

  @Value("classpath:/lecture_5/test-data.sql")
  private Resource dataScript;

  @Bean
  public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
    final DataSourceInitializer initializer = new DataSourceInitializer();
    initializer.setDataSource(dataSource);
    initializer.setDatabasePopulator(databasePopulator());
    return initializer;
  }

  private DatabasePopulator databasePopulator() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(schemaScript);
    populator.addScript(dataScript);
    return populator;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }
}
