package com.platform.leetCode;

public class RepeatedSubstringPattern {
  public static boolean repeatedSubstringPattern(String s) {
    System.out.println((s+s).indexOf(s,1));
    return s.matches("^([a-z]+)\\1+$");
  }

  public static void main(String[] args){
    repeatedSubstringPattern("abab");
  }
}
