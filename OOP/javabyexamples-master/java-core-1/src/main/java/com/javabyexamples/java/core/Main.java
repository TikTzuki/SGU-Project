package com.javabyexamples.java.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

/**
 * Main
 */
@Data
public class Main {
  private final static Logger logger = LoggerFactory.getLogger(Main.class);

  Object message() {
    return "Hello!";
  }

  public static void main(String[] args) {
    System.out.print(new Main().message());
    System.out.print(new Main2().message());
  }
}

class Main2 extends Main {
  String message() {
    return "World!";
  }
}
