package com.epam.core.lecture_4.aspectExample;

import com.epam.core.lecture_1.example.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Override
  @LogExecutionTime
  public User save(User user) throws InterruptedException {
    System.out.println(user + " saved!");
    /*Do some logic*/
    return user;
  }
}
