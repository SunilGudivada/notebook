package com.platform.leetCode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _26_removeDuplicates {
  public int removeDuplicates(int[] nums) {
    nums = Arrays.stream(nums).distinct().toArray();
    System.out.println(Arrays.toString(nums));
    return nums.length;
  }
  public static void main(String[] args) {
    _26_removeDuplicates obj = new _26_removeDuplicates();
    int[] nums = new int[]{1,1,2};

    System.out.println(obj.removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }
}
