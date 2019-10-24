package com.epam.core.lecture_7.jpaExample.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "USER")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotEmpty
  private Long id;

  @Column
  @NotEmpty
  private String name;

  @Column
  @NotEmpty
  private String surname;

  @Column(unique = true)
  @NotEmpty
  private String email;

  @Column
  private String address;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
      cascade = {CascadeType.ALL})
  private List<Task> taskList;
}
