package com.platform.leetCode;

class Solution {

  //two liner
  public int lengthOfLastWord(String s) {
    String[] sa = s.split(" ");
    return sa.length >0 ? sa[sa.length-1].length() : 0;
  }

  //one Liner
  public int lengthofLastWordOneLiner(String s){
    return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
  }
}
