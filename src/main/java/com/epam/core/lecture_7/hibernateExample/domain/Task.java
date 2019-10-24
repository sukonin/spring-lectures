package com.epam.core.lecture_7.hibernateExample.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
  @Column(name = "task_status")
  private TaskStatus taskStatus;

  @Column
  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private LocalDateTime creationTime;

  @ManyToOne
  @JoinColumn(name = "id", nullable = false)
  private User user;

  @ManyToMany(mappedBy = "tasks")
  private List<Tag> tags;
}
