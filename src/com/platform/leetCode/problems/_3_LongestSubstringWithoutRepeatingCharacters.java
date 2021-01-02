package com.platform.leetCode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int res = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      while (set.contains(s.charAt(i))) {
        set.remove(s.charAt(start));
        start++;
      }
      set.add(s.charAt(i));
      res = Math.max(res, i - start + 1);
    }
    return res;
  }

  // Another solution
  public int lengthOfLongestSubstring2(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    int start = 0;
    int end = 0;
    int result = 1;
    Map<Character, Integer> uniqueMap = new HashMap<>();
    while (end < s.length()) {
      char c = s.charAt(end);
      if (uniqueMap.containsKey(c)) {
        int startPrev = uniqueMap.get(c);
        if (startPrev >= start) {
          start = startPrev + 1;
        }
      }
      uniqueMap.put(c, end);
      result = Math.max(end - start + 1, result);
      end++;
    }
    return result;
  }

  public static void main(String[] args) {
    _3_LongestSubstringWithoutRepeatingCharacters obj =
        new _3_LongestSubstringWithoutRepeatingCharacters();
    System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
  }
}
