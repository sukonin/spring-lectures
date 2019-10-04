package com.epam.core.lecture_1.example;

public interface Repository<T> {

  void saveOrUpdate(T entity);
}
