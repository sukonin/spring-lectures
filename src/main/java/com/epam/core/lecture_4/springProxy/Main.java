package com.epam.core.lecture_4.springProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    UserRepositoryImpl userRepository = context.getBean(UserRepositoryImpl.class);
    System.out.println(userRepository.getClass().getName());
  }
}
