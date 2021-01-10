package leetCode.problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert
 * word1 to word2.
 *
 * <p>You have the following three operations permitted on a word:
 *
 * <p>Insert a character Delete a character Replace a character
 *
 * <p>Example 1:
 *
 * <p>Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse (replace 'h' with
 * 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e') Example 2:
 *
 * <p>Input: word1 = "intention", word2 = "execution" Output: 5 Explanation: intention -> inention
 * (remove 't') inention -> enention (replace 'i' with 'e') enention -> exention (replace 'n' with
 * 'x') exention -> exection (replace 'n' with 'c') exection -> execution (insert 'u')
 *
 * <p>Constraints:
 *
 * <p>0 <= word1.length, word2.length <= 500 word1 and word2 consist of lowercase English letters
 */
public class _72_editDistance {

  public int minDistance(String s1, String s2) {
    int dp[][] = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0) dp[i][j] = j;
        else if (j == 0) dp[i][j] = i;
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        else {
          dp[i][j] = 1 + Collections.min(Arrays.asList(
              dp[i - 1][j - 1],
              dp[i][j - 1],
              dp[i - 1][j]
          ));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  public static void main(String[] args) {
    _72_editDistance obj = new _72_editDistance();
    System.out.println(obj.minDistance("horse", "ros"));
  }
}
