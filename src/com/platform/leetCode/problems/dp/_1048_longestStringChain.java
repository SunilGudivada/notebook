package com.platform.leetCode.problems.dp;

import java.util.*;

public class _1048_longestStringChain {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    HashMap<String, Integer> map = new HashMap<>();
    int res = 0;
    for (String word : words) {
      int tempRes = 1;
      StringBuilder string = new StringBuilder(word);
      int N = word.length();
      for (int j = 0; j < N; j++) {
        char ch = string.charAt(j);
        string.deleteCharAt(j);
        if (map.containsKey(string.toString()))
          tempRes = Math.max(tempRes, map.get(string.toString()) + 1);
        string.insert(j, ch);
      }
      map.put(word, tempRes);
      if (tempRes > res) {
        res = tempRes;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _1048_longestStringChain obj = new _1048_longestStringChain();
    String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    System.out.println(obj.longestStrChain(words));
  }
}
