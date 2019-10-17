package com.epam.core.lecture_5.pureJava;

public class Main {

  public static void main(String[] args) {
    UserRepository userRepository = new UserRepository();
    System.out.println(userRepository.findUserById(1L));
  }
}
