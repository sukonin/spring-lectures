package com.epam.core.lecture_2.dependencyInjection;

public class AccountRepositoryImpl implements AccountRepository {

  @Override
  public void findByAccountId(Long id) {
    System.out.println("find account by id: " + id);
  }
}
