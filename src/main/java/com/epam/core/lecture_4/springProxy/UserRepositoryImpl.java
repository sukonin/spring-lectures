package com.epam.core.lecture_4.springProxy;

import com.epam.core.lecture_1.example.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl  {

  @Transactional
  public void save(User user) {
    System.out.println(user + " saved!");
  }


  @Transactional
  public void delete(Long id) {
    System.out.println("user with id: " + id + " deleted!");
  }
}
