package com.platform.leetCode.problems;

import java.util.Arrays;

public class _26_removeDuplicates {
  public int removeDuplicates(int[] nums) {
    int i = 0, j = 0;
    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        nums[++i] = nums[j++];
      }
    }
    System.gc();
    return ++i;
  }
  public static void main(String[] args) {
    _26_removeDuplicates obj = new _26_removeDuplicates();
    int[] nums = new int[]{1,1,2};

    System.out.println(obj.removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }
}
