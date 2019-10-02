package com.epam.core.example;

public class UserService {

  private final Repository<User> userRepository;

  public UserService(Repository<User> userRepository) {
    this.userRepository = userRepository;
  }

  public void save(User user){
    userRepository.saveOrUpdate(user);
  }
}
