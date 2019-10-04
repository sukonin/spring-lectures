package com.epam.core.lecture_2.serviceLocator;

import java.util.ArrayList;
import java.util.List;

public class Cache {

  private List<MessagingService> services = new ArrayList<>();

  public MessagingService getService(String serviceName) {
    return services.stream()
        .filter(m -> m.getServiceName().equals(serviceName))
        .findFirst()
        .orElse(null);
  }

  public void addService(MessagingService messagingService) {
    services.add(messagingService);
  }
}
