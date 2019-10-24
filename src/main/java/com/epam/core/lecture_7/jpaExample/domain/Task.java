package com.epam.core.lecture_7.jpaExample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "TASK")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotEmpty
  private Long id;

  @Column
  private String description;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column
  private TaskStatus taskStatus;

  @ManyToOne
  @JoinColumn(name = "ID", nullable = false)
  private User user;

}
