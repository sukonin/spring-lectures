package com.epam.core.intro.xmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "spring-config.xml");
    Animal bean = context.getBean(Dog.class);
    bean.say();
    House house = context.getBean(House.class);
    house.method();
  }

}
