package com.platform.leetCode.problems.dp;

public class _62_uniquePaths {
  public int uniquePaths(int m, int n) {
    int dp[][] = new int[m + 1][n + 1];
    dp[1][1] = 1;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (i + 1 <= m) {
          dp[i + 1][j] += dp[i][j];
        }
        if (j + 1 <= n) {
          dp[i][j + 1] += dp[i][j];
        }
      }
    }
//    for (int i = 0; i <= m; i++) {
//      for (int j = 0; j <= n; j++) {
//        System.out.print(dp[i][j] + " ");
//      }
//      System.out.println();
//    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    _62_uniquePaths obj = new _62_uniquePaths();
    System.out.println(obj.uniquePaths(3, 2));
  }
}
