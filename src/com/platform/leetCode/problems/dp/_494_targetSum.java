package com.platform.leetCode.problems.dp;

public class _494_targetSum {
  int count = 0;

  public int findTargetSumWays(int[] nums, int S) {
    calculate(nums, 0, 0, S);
    return count;
  }

  public void calculate(int[] nums, int i, int sum, int S) {
    if (i == nums.length) {
      if (sum == S) count++;
    } else {
      calculate(nums, i + 1, sum + nums[i], S);
      calculate(nums, i + 1, sum - nums[i], S);
    }
  }

  public int findTargetSumWays2(int[] nums, int S) {
    int sum = 0;
    for (int i : nums) sum += i;
    if (S > sum || S < -sum) return 0;
    int[][] dp = new int[nums.length][sum * 2 + 1];
    dp[0][nums[0] + sum] = 1;
    dp[0][-nums[0] + sum] += 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = -sum; j <= sum; j++) {
        if (dp[i - 1][j + sum] != 0) {
          int n = nums[i];
          dp[i][j + sum + n] += dp[i - 1][j + sum];
          dp[i][j + sum - n] += dp[i - 1][j + sum];
        }
      }
    }
    return dp[nums.length - 1][S + sum];
  }

  public static void main(String[] args) {
    _494_targetSum obj = new _494_targetSum();
    int[] nums = new int[] {1, 1, 1, 1, 1};
    int target = 3;
    System.out.println(obj.findTargetSumWays(nums, target));
  }
}
