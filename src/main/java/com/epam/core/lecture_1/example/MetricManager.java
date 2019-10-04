package com.epam.core.lecture_1.example;

import java.util.Random;

public class MetricManager {

  private Random random = new Random();

  public void logMetric() {
    long time = random.nextInt(1000);
    System.out.println("executed in " + time + " ms!");
  }
}

