package com.epam.core.lecture_1.intro.xmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "lecture_1/spring-config.xml");
    Animal bean = context.getBean(Dog.class);
    bean.say();
    House house = context.getBean(House.class);
    house.method();
  }

}
