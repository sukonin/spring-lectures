package com.epam.core.lecture_7.embeddedExample;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

  private String firstName;

  private String middleName;

  private String lastName;
}
