package com.epam.core.lecture_2.serviceLocator;

public class InitialContext {

  public Object lookup(String serviceName) {
    if (serviceName.equalsIgnoreCase("EmailService")) {
      return new EmailService();
    } else if (serviceName.equalsIgnoreCase("SMSService")) {
      return new SMSService();
    }
    throw new IllegalArgumentException();
  }
}
