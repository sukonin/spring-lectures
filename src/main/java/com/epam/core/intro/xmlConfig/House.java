package com.epam.core.intro.xmlConfig;

public class House {

  private Dog dog;
  private Cat cat;

  public House(Dog dog, Cat cat) {
    this.dog = dog;
    this.cat = cat;
  }

  public void method(){
    dog.say();
    cat.say();
  }
}
