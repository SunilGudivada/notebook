package com.company.leetCode;

class Solution {
  public int lengthOfLastWord(String s) {
    String[] sa = s.split(" ");
    return sa.length >0 ? sa[sa.length-1].length() : 0;
  }
}
