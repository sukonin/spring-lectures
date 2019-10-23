package com.epam.core.lecture_6.transactionExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

  private final UserRepository userRepository;

  private TransactionService transactionService;

  @Autowired
  public void setTransactionService(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  public TransactionServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void init() {
    User user = new User();
    user.setId(1L);
    user.setName("Name");
    user.setSurname("Surname");

    userRepository.save(user);
  }

  @Transactional
  public void dirtyRead() {
    User user = new User();
    user.setId(1L);
    user.setSurname("Blabla");
    user.setName("Blabla");

    userRepository.update(user);

    transactionService.readInAnotherTransaction();
  }

  @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
  public void readInAnotherTransaction() {
    System.out.println(userRepository.findAllById(1L));
  }


  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void repeatableReads() {
    System.out.println(userRepository.findAllById(1L));

    transactionService.changeFromAnotherTransaction();

    System.out.println(userRepository.findAllById(1L));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void changeFromAnotherTransaction() {
    User user = new User();
    user.setId(1L);
    user.setSurname("Another Data");
    user.setName("Another Data");

    userRepository.update(user);
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  public void phantomReads() {
    System.out.println(userRepository.findAll().size());

    transactionService.insertFromAnotherTransaction();

    System.out.println(userRepository.findAll().size());
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void insertFromAnotherTransaction() {
    User user = new User();
    user.setId(2L);
    user.setName("second name");
    user.setSurname("second surname");

    userRepository.save(user);
  }
}
