package com.epam.core.lecture_1.intro.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class House {

  private Dog dog;
  private Cat cat;

  @Autowired
  public House(Dog dog, Cat cat) {
    this.dog = dog;
    this.cat = cat;
  }

  public void method(){
    dog.say();
    cat.say();
  }
}
