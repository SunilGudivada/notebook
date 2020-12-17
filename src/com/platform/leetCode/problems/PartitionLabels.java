package com.platform.leetCode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionLabels {

  private static final Scanner sc = new Scanner(System.in);

  public static List<Integer> divideIntoStrings(String str) {
    List<String> strings = new ArrayList<>();
    int splitEndIndex = 0;
    String temp = "";
    for (int i = 0; i < str.length(); i++) {
      int index = str.lastIndexOf(str.charAt(i));
      temp = temp + str.charAt(i);
      if (index >= splitEndIndex) {
        splitEndIndex = index;
      }
      if (splitEndIndex == i) {
        strings.add(temp);
        temp = "";
        splitEndIndex = i;
      }
    }
    List<Integer> stringCount = new ArrayList<>();
    for (String a : strings) {
      stringCount.add(a.length());
    }
    return stringCount;
  }

  public static void main(String[] args) {
    //    String str = sc.nextLine();
    String str = "abcdfg";
    List<Integer> strArr = divideIntoStrings(str);
    for (Integer s : strArr) {
      System.out.println(s);
    }
  }
}
