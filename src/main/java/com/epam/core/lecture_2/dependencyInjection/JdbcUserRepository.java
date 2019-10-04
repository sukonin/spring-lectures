package com.epam.core.lecture_2.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class JdbcUserRepository implements UserRepository {

  @Override
  public void findById(Long id) {
    System.out.println("JdbcUserRepository: find user with id: " + id);
  }
}
