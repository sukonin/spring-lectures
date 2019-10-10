package com.epam.core.lecture_3.lookupExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        "com.epam.core.lecture_3.lookupExample");

    SingletonBean bean = context.getBean(SingletonBean.class);

  }
}
