package com.epam.core.lecture_4.dynamicProxy;

import com.epam.core.lecture_1.example.User;

public class UserRepositoryImpl implements UserRepository {

  @Override
  public void save(User user) {
    System.out.println(user + " saved");
  }
}
