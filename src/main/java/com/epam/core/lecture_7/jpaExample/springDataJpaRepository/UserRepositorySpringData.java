package com.epam.core.lecture_7.jpaExample.springDataJpaRepository;


import com.epam.core.lecture_7.jpaExample.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepositorySpringData {

  List<User> findAllByAddress(@Param("address") String address);
}
