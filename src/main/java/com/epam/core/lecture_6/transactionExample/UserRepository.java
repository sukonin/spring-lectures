package com.epam.core.lecture_6.transactionExample;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository {


  List<User> findAllById(Long id);

  int save(User user);

  int update(User user);

  int deleteById(Long id);

  List<User> findAll();

  User findById(Long id);

  void clearDb();
}
