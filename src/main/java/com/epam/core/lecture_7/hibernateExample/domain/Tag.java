package com.epam.core.lecture_7.hibernateExample.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "TAG")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotEmpty
  private Long id;

  @Column
  private String tag;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name = "task_tag",
      joinColumns = {@JoinColumn(name = "tag_id")},
      inverseJoinColumns = {@JoinColumn(name = "task_id")})
  private List<Task> tasks;
}
