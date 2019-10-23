package com.epam.core.lecture_6.transactionExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.CannotAcquireLockException;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        "com.epam.core.lecture_6.transactionExample");

    TransactionService transactionService = context.getBean(TransactionService.class);
    transactionService.init();

    try {

      //transactionService.dirtyRead();

      //transactionService.repeatableReads();

      transactionService.phantomReads();

    } catch (CannotAcquireLockException exception) {
      System.out.println("---Can't acquire lock for dirtyReads!---");
    }
  }

}
