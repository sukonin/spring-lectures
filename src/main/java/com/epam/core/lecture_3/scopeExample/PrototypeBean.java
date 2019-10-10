package com.epam.core.lecture_3.scopeExample;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

  public PrototypeBean() {
    System.out.println("Prototype was created");
  }

  public void method() {
    /*logic here*/
  }
}
