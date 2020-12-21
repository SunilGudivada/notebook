package com.platform.leetCode.problems.dp;

import java.util.Arrays;

public class _322_coinChange {
  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[amount + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i <= amount; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = dp[i][j - 1];
        if (coins[j - 1] <= i) dp[i][j] += dp[i - coins[j - 1]][j];
      }
    }

    for (int i=0;i<=amount;i++){
      for (int j=0;j<=n;j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return dp[amount][n];
  }

  public static void main(String[] args) {
    _322_coinChange obj = new _322_coinChange();
    System.out.println(obj.coinChange(new int[] {1, 2, 3}, 4));
  }
}
