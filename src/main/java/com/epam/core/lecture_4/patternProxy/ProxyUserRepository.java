package com.epam.core.lecture_4.patternProxy;

import com.epam.core.lecture_1.example.User;
import java.util.Objects;

public class ProxyUserRepository implements UserRepository {

  private UserRepository userRepository = new UserRepositoryImpl();

  @Override
  public void save(User user) {
    /*Some additional logic*/
    if (Objects.isNull((user.getName()))) {
      throw new RuntimeException("Username cannot be empty!");
    }

    userRepository.save(user);
  }
}
