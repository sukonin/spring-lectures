package com.epam.core.lecture_4.dynamicProxy;

import com.epam.core.lecture_1.example.User;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class UserRepositoryInvocationHandler implements InvocationHandler {

  private UserRepository userRepository;

  public UserRepositoryInvocationHandler(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    if(method.getName().equals("save")){
      User user = (User) args[0];
      Objects.requireNonNull(user, "User cannot be null!");
    }

    return method.invoke(userRepository, args);
  }
}
