package com.epam.core.lecture_4.springProxy;

import com.epam.core.lecture_1.example.User;

public interface UserRepository {

  void save(User user);

  void delete(Long id);
}
