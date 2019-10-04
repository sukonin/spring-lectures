package com.epam.core.lecture_2.factoryMethod;

public class CodecFactory {

  private CodecFactory() {
  }

  public static Codec getCodec(String format) {
    if (format.equals("jpg")) {
      return new ImageCodec();
    }
    if (format.equals("mov")) {
      return new VideoCodec();
    }
    if (format.equals("mp3")) {
      return new AudioCodec();
    } else {
      throw new IllegalArgumentException();
    }
  }
}
