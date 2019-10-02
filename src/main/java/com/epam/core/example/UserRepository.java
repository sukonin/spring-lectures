package com.epam.core.example;

public class UserRepository implements Repository<User> {

  @Override
  public void saveOrUpdate(User user) {
    System.out.println("Saved " + user);
  }
}
