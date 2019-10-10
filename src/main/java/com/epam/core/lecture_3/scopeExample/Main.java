package com.epam.core.lecture_3.scopeExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        "com.epam.core.lecture_3.scopeExample");

    SingletonBean bean = context.getBean(SingletonBean.class);
    SingletonBean anotherSingleton = context.getBean(SingletonBean.class);

    System.out.println(bean.equals(anotherSingleton));

    PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
    PrototypeBean anotherPrototype = context.getBean(PrototypeBean.class);

    System.out.println(prototypeBean.equals(anotherPrototype));
  }

  /*    ((DefaultListableBeanFactory) context.getBeanFactory()).destroySingleton("name");

   ((BeanDefinitionRegistry) beanFactory).removeBeanDefinition("myBean");
   */
}
