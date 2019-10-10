package com.epam.core.lecture_3.lookupExample;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PrototypeBean {

  public PrototypeBean() {
    System.out.println("PrototypeBean was created");
  }

  public void method() {
    /*some logic*/
  }
}
