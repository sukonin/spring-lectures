package com.epam.core.lecture_2.serviceLocator;

public class ServiceLocator {

  private static Cache cache = new Cache();

  public static MessagingService getService(String serviceName) {

    MessagingService service = cache.getService(serviceName);

    if (service != null) {
      return service;
    }

    InitialContext context = new InitialContext();
    MessagingService messagingService = (MessagingService) context.lookup(serviceName);
    cache.addService(messagingService);
    return messagingService;
  }
}
