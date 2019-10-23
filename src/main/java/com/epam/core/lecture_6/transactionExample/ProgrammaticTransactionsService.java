package com.epam.core.lecture_6.transactionExample;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ProgrammaticTransactionsService {

  private final UserRepository userRepository;

  private final TransactionTemplate transactionTemplate;

  public ProgrammaticTransactionsService(UserRepository userRepository,
      TransactionTemplate transactionTemplate) {
    this.userRepository = userRepository;
    this.transactionTemplate = transactionTemplate;
  }

  public int updatePassword(Long id, String newSurname) {
    return transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          User user = userRepository.findById(id);
          String email = user.getEmail();
          ProgrammaticTransactionsService.this.sendEmail(email);
          user.setSurname(newSurname);
          return userRepository.update(user);
        } catch (IllegalArgumentException e) {
          status.setRollbackOnly();
        }
        return 0;
      }
    });
  }

  public int findById(Long id) {
    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
      @Override
      protected void doInTransactionWithoutResult(TransactionStatus status) {
        /*Do some Logic*/
      }
    });
    return 0;
  }

  private void sendEmail(String email) {
    /*Validate and send EMAIL*/
  }


}
