package com.javabyexamples.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SortArrayList
 */

public class SortArrayList {
  public List<String> names = new ArrayList<>();
  public final static Logger logger = LoggerFactory.getLogger(SortArrayList.class);

  public SortArrayList(String[] names) {
    this.names = Arrays.asList(names);
  }

  public void sort() {
    names.sort(Comparator.comparing(String::toString));
  }

  public void sort1() {
    names = names.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
  }

  public void sort2() {
    Collections.sort(names);
  }

  public void forLoop() {
    for (int i = 0; i < 10; i = ++i) {
      logger.error("i=" + i);
    }
  }

  public String print(String message) {
    System.out.print(message);
    message = "hihi";
    return message;
  }

  public static void main(String[] args) {
    List<String> list2 = new ArrayList<>(Arrays.asList(new String[] { "long", "nhuy" }));
    Iterator it = list2.iterator();
    while (it.hasNext()) {
      logger.info(it.next().toString());
    }
    list2.forEach(System.out::println);
  }
}
