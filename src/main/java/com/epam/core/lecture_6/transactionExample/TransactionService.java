package com.epam.core.lecture_6.transactionExample;

public interface TransactionService {

  void init();

  void dirtyRead();

  void readInAnotherTransaction();

  void repeatableReads();

  void changeFromAnotherTransaction();

  void phantomReads();

  void insertFromAnotherTransaction();
}
