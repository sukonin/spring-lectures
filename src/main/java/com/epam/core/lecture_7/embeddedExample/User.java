package com.epam.core.lecture_7.embeddedExample;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @EmbeddedId
  private UserId userId;

  @Embedded
  private Name name;
}
