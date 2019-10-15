package com.epam.core.lecture_4.aspectExample;

import com.epam.core.lecture_1.example.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    UserRepository userRepository = context.getBean(UserRepository.class);
    User user = new User();
    user.setName("Vasya");

    userRepository.save(user);
  }
}
