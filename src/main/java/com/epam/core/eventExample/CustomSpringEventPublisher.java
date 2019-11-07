package com.epam.core.eventExample;

import com.epam.core.lecture_6.transactionExample.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher implements ApplicationContextAware {

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("Publishing custom event. ");

    User user = new User();
    user.setSurname("surname");
    user.setId(1L);
    user.setName("Name");
    user.setEmail("Email");

    CustomSpringEvent customSpringEvent = new CustomSpringEvent(user, "Some some message");

    applicationContext.publishEvent(customSpringEvent);
  }
}
