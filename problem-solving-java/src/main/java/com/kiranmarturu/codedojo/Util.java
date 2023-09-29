package com.kiranmarturu.codedojo;

import java.util.Arrays;

class Util {

  private Util() {}

  static void printResult(String input, int expected, int actual) {
    System.out.println(
      String.format(
        "%s Expected: %d | Actual: %d | Result: %s",
        input,
        expected,
        actual,
        actual == expected ? "PASS" : "FAIL"
      )
    );
  }

  static void printResult(int[] tc1, int expected, int actual) {
    System.out.println(
      String.format(
        "%s Expected: %d | Actual: %d | Result: %s",
        Arrays.toString(tc1),
        expected,
        actual,
        actual == expected ? "PASS" : "FAIL"
      )
    );
  }
}
