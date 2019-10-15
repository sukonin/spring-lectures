package com.epam.core.lecture_4.aspectExample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
@Aspect
@Component
public class LoggingAspectAdvanced {

  @Pointcut("@annotation(com.epam.core.lecture_4.aspectExample.LogExecutionTime)")
  public void annotated() {
  }

  @Around("annotated()")
  public Object handleArguments(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    Object proceed = joinPoint.proceed();

    long executionTime = System.currentTimeMillis() - start;

    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

    return proceed;
  }

  @AfterReturning(value = "@target(org.springframework.stereotype.Repository)", returning = "returnValue")
  public void afterReturn(Object returnValue) {
    System.out.println(returnValue);
  }
}
*/
