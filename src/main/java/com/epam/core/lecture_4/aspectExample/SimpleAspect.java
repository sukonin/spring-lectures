package com.epam.core.lecture_4.aspectExample;

import com.epam.core.lecture_1.example.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {

  private Map<String, Object> cache = new HashMap<>();

  @Pointcut("execution(* com.epam.core.lecture_4.aspectExample.UserRepository.*(..))")
  public void handle() {
  }

  @Before("handle()")
  public void handleArguments(JoinPoint joinPoint) {
    Object object = joinPoint.getArgs()[0];
    System.out.println("Validating User..." + object);

    if (object instanceof User) {
      Objects.requireNonNull(object, "User cannot be null");
    }
  }

  @AfterReturning(value = "handle()", returning = "object")
  public void chacing(JoinPoint joinPoint, Object object) {
    if (object instanceof User) {
      cache.put(object.getClass().getName(), object);
      System.out.println(object + "put to cache");
    }
  }

  @AfterThrowing(value = "handle()", throwing = "exception")
  public void rollback(Exception exception) {
    /*ROLLBACK CHANGES IN DATABASE*/
    System.out.println(exception.getMessage());
  }

  @After(value = "handle()")
  public void logging(JoinPoint joinPoint) {
    System.out.println("After advice works on method: " + joinPoint.getSignature());
  }

  @Around("handle()")
  public Object metric(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    Object proceed = joinPoint.proceed();

    long executionTime = System.currentTimeMillis() - start;

    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

    return proceed;
  }
}
