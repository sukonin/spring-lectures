package com.epam.core.lecture_5.jdbcTemplate;

import com.epam.core.lecture_5.pureJava.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        SimpleDatabaseConfig.class);

    UserRepository userRepository = context.getBean(UserRepository.class);
    System.out.println(userRepository.findById(1L));

/*    User user = new User();
    user.setId(2L);
    user.setName("Vasya");
    user.setSurname("Filippov");

    userRepository.save(user);

    System.out.println(userRepository.findById(2L));*/

    System.out.println(userRepository.findAll());
  }
}
