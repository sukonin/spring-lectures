package com.epam.core.lecture_2.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void findUserById(Long id) {
    userRepository.findById(id);
  }

  @Autowired
  public void setAccountRepository(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }
}
