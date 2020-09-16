/** https://leetcode.com/contest/biweekly-contest-33/problems/thousand-separator/
 *
 * Using StringBuilder ( insert function to insert by provding the index to be added ( "." )
 * */
package com.platform.leetCode;

public class thousandSeperator {
  public static String dotSeperator(int n) {
    StringBuilder sb = new StringBuilder().append(n);
    if (sb.length() < 4) return sb.toString();
    for (int i = sb.length() - 3; i > 0; i -= 3) {
      sb.insert(i, ".");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(dotSeperator(1234567));
  }
}
