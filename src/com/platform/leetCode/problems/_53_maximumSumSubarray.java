package com.platform.leetCode.problems;

public class _53_maximumSumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums.length < 1) return 0;
    if (nums.length == 1) return nums[0];

    int currSum=0;
    int maxSum=Integer.MIN_VALUE;

    for(int num : nums){
      currSum += num;
      if(num > currSum) currSum=num;
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    _53_maximumSumSubarray obj = new _53_maximumSumSubarray();
    System.out.println(obj.maxSubArray(new int[]{1,2,4,8}));
  }
}
