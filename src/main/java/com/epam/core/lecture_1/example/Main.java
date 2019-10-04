package com.epam.core.lecture_1.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "lecture_1/spring-example-xml-config.xml");

    UserService userService = context.getBean(UserService.class);
    User user = new User();
    user.setId(1L);
    user.setName("Вася");
    user.setAddress("Заставская 22A");
    userService.save(user);
  }
}
