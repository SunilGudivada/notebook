package com.platform.leetCode.problems.dp;

public class _377_combinationSum4 {
  public int combinationSum4(int[] vals, int sum) {
    if (sum < 0) {
      return 0;
    }
    if (vals == null || vals.length == 0) {
      return 0;
    }

    int[] dp = new int[sum + 1];
    dp[0] = 1;
    for (int j = 1; j <= sum; j++) {
      for (int val : vals) {
        if (val - j <= 0) {
          dp[j] += dp[j - val];
        }
      }
    }
    return dp[sum];
  }

  public static void main(String[] args) {
    _377_combinationSum4 obj = new _377_combinationSum4();
    int[] nums = new int[] {1, 2, 3};
    int target = 4;
    System.out.println(obj.combinationSum4(nums, target));
  }
}
