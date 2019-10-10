package com.epam.core.lecture_3.scopeExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


  @Bean
  public SingletonBean singletonBean1() {
    return new SingletonBean();
  }

  @Bean
  public SingletonBean singletonBean2() {
    return new SingletonBean();
  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
        Config.class);

    SingletonBean singletonBean1 = (SingletonBean) annotationConfigApplicationContext
        .getBean("singletonBean1");
    SingletonBean singletonBean2 = (SingletonBean) annotationConfigApplicationContext
        .getBean("singletonBean2");

    System.out.println(singletonBean1.equals(singletonBean2));
  }

}
