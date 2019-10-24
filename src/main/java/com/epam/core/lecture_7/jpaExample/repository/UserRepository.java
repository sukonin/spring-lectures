package com.epam.core.lecture_7.jpaExample.repository;

import com.epam.core.lecture_7.jpaExample.domain.User;
import java.util.List;

public interface UserRepository {


  User findById(Long id);

  void saveOrUpdate(User user);

  void update(User user);

  void deleteById(User user);

  List<User> findAll();
}
