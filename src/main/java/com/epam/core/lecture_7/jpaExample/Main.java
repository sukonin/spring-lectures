package com.epam.core.lecture_7.jpaExample;

import com.epam.core.lecture_7.jpaExample.config.AppConfig;
import com.epam.core.lecture_7.jpaExample.domain.Task;
import com.epam.core.lecture_7.jpaExample.domain.User;
import com.epam.core.lecture_7.jpaExample.repository.UserRepository;
import com.epam.core.lecture_7.jpaExample.springDataJpaRepository.UserRepositorySpringData;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Pageable;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
        AppConfig.class);

    UserRepository userRepository = annotationConfigApplicationContext
        .getBean(UserRepository.class);

    User user = new User();
    user.setName("name");
    user.setEmail("email");
    user.setSurname("surname");
    user.setAddress("address");

    userRepository.saveOrUpdate(user);

    System.out.println(userRepository.findAll());

    UserRepositorySpringData bean = annotationConfigApplicationContext
        .getBean(UserRepositorySpringData.class);

    bean.findAllByAddress("address");
  }

}
