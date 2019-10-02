package com.epam.core.example;

public interface Repository<T> {

  void saveOrUpdate(T entity);
}
