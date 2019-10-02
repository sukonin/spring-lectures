package com.epam.core.intro.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context
        = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    House bean = context.getBean(House.class);
    bean.method();
  }
}
