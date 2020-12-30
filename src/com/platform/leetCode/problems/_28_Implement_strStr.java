package com.platform.leetCode.problems;

/**
 * Implement strStr().
 *
 * <p>Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 *
 * <p>Clarification:
 *
 * <p>What should we return when needle is an empty string? This is a great question to ask during
 * an interview.
 *
 * <p>For the purpose of this problem, we will return 0 when needle is an empty string. This is
 * consistent to C's strstr() and Java's indexOf().
 *
 * <p>Example 1:
 *
 * <p>Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 *
 * <p>Input: haystack = "aaaaa", needle = "bba" Output: -1 Example 3:
 *
 * <p>Input: haystack = "", needle = "" Output: 0
 *
 * <p>Constraints:
 *
 * <p>0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack and needle consist of only lower-case English characters.
 *
 */
public class _28_Implement_strStr {
  public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  public static void main(String[] args) {
    _28_Implement_strStr obj = new _28_Implement_strStr();
    String haystack = "hello";
    String needle = "ll";
    System.out.println(obj.strStr(haystack, needle));
  }
}
