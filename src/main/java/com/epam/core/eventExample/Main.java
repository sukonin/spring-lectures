package com.epam.core.eventExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        "com.epam.core.eventExample");

    CustomSpringEventPublisher bean = applicationContext.getBean(CustomSpringEventPublisher.class);
  }
}
