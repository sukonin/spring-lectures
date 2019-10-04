package com.epam.core.lecture_1.intro.annotationConfig;

import com.epam.core.lecture_1.intro.xmlConfig.Animal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

  @Override
  public void say() {
    System.out.println("Wuf");
  }
}
