package com.epam.core.lecture_2.serviceLocator;

public class EmailService implements MessagingService {

  public String getMessageBody() {
    return "email message text";
  }

  public String getServiceName() {
    return "EmailService";
  }
}
