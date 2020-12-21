package com.platform.leetCode.problems.dp;

public class _300_longestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = 1;
    int res = lis[0];
    for (int i = 1; i < n; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          lis[i] = Math.max(lis[i], 1 + lis[j]);
        }
      }
      res = Math.max(res, lis[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    _300_longestIncreasingSubsequence obj = new _300_longestIncreasingSubsequence();
    System.out.println(obj.lengthOfLIS(new int[] {3, 4, 2, 8, 10, 5, 1}));
  }
}
