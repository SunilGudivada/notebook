package com.platform.leetCode.problems.dp;

public class _70_climbingStairs {
  public int climbStairs(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<=n;i++){
      dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    _70_climbingStairs obj = new _70_climbingStairs();
    System.out.println(obj.climbStairs(3));
  }
}
