package com.epam.core.lecture_1.intro.annotationConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
        "com.epam.core.lecture_1.intro.annotationConfig");

    House bean = annotationConfigApplicationContext.getBean(House.class);
    bean.method();
  }
}
