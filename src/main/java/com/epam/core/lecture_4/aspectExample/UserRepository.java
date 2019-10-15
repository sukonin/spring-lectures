package com.epam.core.lecture_4.aspectExample;

import com.epam.core.lecture_1.example.User;

public interface UserRepository {

  User save(User user) throws InterruptedException;
}
