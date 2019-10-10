package com.epam.core.lecture_3.scopeExample;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

  public SingletonBean() {
    System.out.println("Singleton was created");
  }

  public void method() {
    /*logic here*/
  }
}
