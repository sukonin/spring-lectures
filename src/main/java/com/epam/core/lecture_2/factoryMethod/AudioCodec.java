package com.epam.core.lecture_2.factoryMethod;

public class AudioCodec implements Codec {

  @Override
  public void decode(String fileName) {
    System.out.println(fileName + " decode to audio");
  }
}
