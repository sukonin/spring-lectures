package com.epam.core.lecture_5.jdbcTemplate;

import com.epam.core.lecture_5.pureJava.User;
import java.util.List;

public interface UserRepository {

  User findById(Long id);

  int save(User user);

  int update(User user);

  int deleteById(Long id);

  List<User> findAll();
}
