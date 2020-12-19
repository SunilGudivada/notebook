package com.platform.leetCode.problems.dp;

import java.util.Arrays;
import java.util.Collections;

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
