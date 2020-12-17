package com.platform.leetCode.problems;

import java.util.Arrays;
import java.util.HashMap;

public class _001_TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i=0;i<nums.length;i++){
      if(map.get(target - nums[i]) != null){
        int[] response = new int[2];
        response[0] = Math.min(i,map.get(target - nums[i]));
        response[1] = Math.max(i,map.get(target - nums[i]));
        return response;
      }
      map.put(nums[i],i);
    }
    return new int[0];
  }
  public static void main(String... args) {
    int nums[] = {2,7,11,15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }
}