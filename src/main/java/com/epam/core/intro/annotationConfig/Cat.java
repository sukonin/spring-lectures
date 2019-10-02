package com.epam.core.intro.annotationConfig;

import com.epam.core.intro.xmlConfig.Animal;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

  @Override
  public void say() {
    System.out.println("May");
  }
}
