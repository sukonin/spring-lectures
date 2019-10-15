package com.epam.core.lecture_4.dynamicProxy;

import com.epam.core.lecture_1.example.User;
import java.lang.reflect.Proxy;

public class Main {

  public static void main(String[] args) {

    UserRepository userRepository = new UserRepositoryImpl();

    UserRepositoryInvocationHandler handler = new UserRepositoryInvocationHandler(userRepository);

    UserRepository newProxyInstance = (UserRepository) Proxy.newProxyInstance(
        UserRepository.class.getClassLoader(),
        new Class[]{UserRepository.class},
        handler);

    User user = new User();
    user.setId(1L);
    user.setAddress("Boston");
    user.setName("Vasya");

    newProxyInstance.save(null);
  }
}
