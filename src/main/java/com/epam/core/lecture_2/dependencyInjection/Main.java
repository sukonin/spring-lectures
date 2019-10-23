package com.epam.core.lecture_2.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    /*ApplicationContext context = new ClassPathXmlApplicationContext("lecture_2/spring-config.xml");

    UserService userService = context.getBean(UserService.class);
    userService.createUser(1L);*/

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        "com.epam.core.lecture_2.dependencyInjection");

    UserService bean = context.getBean(UserService.class);
    bean.findUserById(1L);
  }
}
