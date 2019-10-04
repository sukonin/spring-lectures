package com.epam.core.lecture_2.serviceLocator;

public class SMSService implements MessagingService {

  @Override
  public String getMessageBody() {
    return "sms message text";
  }

  @Override
  public String getServiceName() {
    return "SMSService";
  }
}
