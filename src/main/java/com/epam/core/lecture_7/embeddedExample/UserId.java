package com.epam.core.lecture_7.embeddedExample;

import javax.persistence.Embeddable;

@Embeddable
public class UserId {

  private Long id;

  private String clientId;

}
