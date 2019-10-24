package com.epam.core.lecture_7.hibernateExample.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan("com.epam.core.lecture_7.hibernateExample")
public class AppConfig {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .build();
  }

  @Bean
  public SessionFactory sessionFactory() {
    return new LocalSessionFactoryBuilder(dataSource())
        .scanPackages("com.epam.core.lecture_7.hibernateExample.domain")
        .addProperties(hibernateProperties())
        .buildSessionFactory();
  }

  @Bean
  public Properties hibernateProperties() {
    Properties hibernateProp = new Properties();
    hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

    //create-only, drop, create, create-drop, validate, update
    hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");

    //if true, and the "show_sql" is true also, the generated
    //SQL statements are printed to the console in a pretty and readable way.
    hibernateProp.put("hibernate.format_sql", true);

    //hibernate.show_sql: if true, all the generated SQL statements are printed to
    //the console.
    hibernateProp.put("hibernate.use_sql_comments", true);

    //if true, Hibernate will put a comment inside the
    //SQL statement to tell the developer what that statement is trying to do.
    hibernateProp.put("hibernate.show_sql", true);
    return hibernateProp;
  }

}
