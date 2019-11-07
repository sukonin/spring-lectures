package com.epam.core.lecutre_10_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
        "com.epam.core.lecutre_10_lifecycle");

    ExampleBeanLifecycle bean = annotationConfigApplicationContext
        .getBean(ExampleBeanLifecycle.class);

    bean.method();

    System.out.println(bean.getSomeValue());

    System.out.println(bean.getRandomInt());

    annotationConfigApplicationContext.close();
  }
}
