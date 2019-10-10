package com.epam.core.lecture_3.LazyAndDependsOn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class EagerBean {

  public EagerBean() {
    System.out.println("I'm so eager!");
  }
}

@Component
@DependsOn(value = "lazyBean")
class DependableBean {

  public DependableBean() {
    System.out.println("DependableBean");
  }
}

@Component
@Lazy
class LazyBean {

  public LazyBean() {
    System.out.println("I'm soooo lazyyyy...");
  }
}


class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext =
        new AnnotationConfigApplicationContext(
        "com.epam.core.lecture_3.LazyAndDependsOn");
    DependableBean bean = annotationConfigApplicationContext.getBean(DependableBean.class);
  }
}

