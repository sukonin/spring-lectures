package com.epam.core.lecture_3.populateExample;

import com.epam.core.lecture_2.dependencyInjection.UserRepository;

public class ServiceBean {

  private String someString;
  private int someInt;

  public ServiceBean(String someString, int someInt) {
    this.someString = someString;
    this.someInt = someInt;
  }

  public ServiceBean(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private UserRepository userRepository;

  private String url;
  private String username;
  private String password;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ServiceBean() {

  }

  public void setUrl(String url) {
    this.url = url;
  }
}
