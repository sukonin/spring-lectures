package com.epam.core.lecture_1.intro.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public Cat cat(){
    return new Cat();
  }

  @Bean
  public Dog dog(){
    return new Dog();
  }

  @Bean
  public House house(){
    return new House(dog(), cat());
  }
}
