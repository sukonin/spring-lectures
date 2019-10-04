package com.epam.core.lecture_2.serviceLocator;


public class Main {

  public static void main(String[] args) {
    MessagingService service = ServiceLocator.getService("EmailService");
    String email = service.getMessageBody();
    System.out.println(email);

    MessagingService smsService = ServiceLocator.getService("SMSService");
    String sms = smsService.getMessageBody();
    System.out.println(sms);

    MessagingService emailService = ServiceLocator.getService("EmailService");
    System.out.println(service.equals(emailService));
  }
}
