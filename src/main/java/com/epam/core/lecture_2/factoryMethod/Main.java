package com.epam.core.lecture_2.factoryMethod;

public class Main {

  public static void main(String[] args) {
    String fileName = "гарри_поттер.mov";
    String format = fileName.substring(fileName.indexOf('.') + 1);

    Codec codec = CodecFactory.getCodec(format);
    codec.decode(fileName);
  }
}
