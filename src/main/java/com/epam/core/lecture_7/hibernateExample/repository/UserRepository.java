package com.epam.core.lecture_7.hibernateExample.repository;

import com.epam.core.lecture_7.hibernateExample.domain.User;
import java.util.List;

public interface UserRepository {

  User findById(Long id);

  void save(User user);

  void update(User user);

  void deleteById(Long id);

  List<User> findAll();
}
