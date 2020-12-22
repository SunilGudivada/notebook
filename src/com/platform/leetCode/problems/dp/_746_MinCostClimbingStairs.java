package com.platform.leetCode.problems.dp;

public class _746_MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    int dp[] = new int[cost.length+1];

    if (cost.length > 2) {
      dp[0] = Math.min(cost[0], cost[1]);
      dp[1] = Math.min(cost[1], cost[2]);
      for (int i = 2; i <= cost.length; ++i) {
        dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == cost.length ? 0 : cost[i]);
      }
    }
    return dp[cost.length];
  }

  public static void main(String[] args) {
    _746_MinCostClimbingStairs obj = new _746_MinCostClimbingStairs();
    System.out.println(obj.minCostClimbingStairs(new int[]{1, 100}));
  }
}
