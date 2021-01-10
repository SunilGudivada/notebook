package leetCode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many
 * parts as possible so that each letter appears in at most one part, and return a list of integers
 * representing the size of these parts.
 *
 * <p>Example 1:
 *
 * <p>Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation: The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * <p>Note:
 *
 * <p>S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class _763_PartitionLabels {

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
