package com.platform.leetCode.problems.dp;

import java.util.Arrays;

public class _322_coinChange {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    _322_coinChange obj = new _322_coinChange();
    System.out.println(obj.coinChange(new int[] {1, 2, 3}, 4));
  }
}
