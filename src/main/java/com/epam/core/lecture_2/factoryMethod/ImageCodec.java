package com.epam.core.lecture_2.factoryMethod;

public class ImageCodec implements Codec {

  @Override
  public void decode(String fileName) {
    System.out.println(fileName + " decode to image");
  }
}
