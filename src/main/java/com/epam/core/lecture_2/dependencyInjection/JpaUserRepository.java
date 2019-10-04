package com.epam.core.lecture_2.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class JpaUserRepository implements UserRepository {

  @Override
  public void findById(Long id) {
    System.out.println("JpaUserRepository: find user with id: " + id);
  }
}
