package com.platform.leetCode;

public class houseRobber {
  public static int get(int[] nums){
    int evenCount = 0;
    int oddCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if(i%2 ==0){
        evenCount += nums[i];
      }else{
        oddCount += nums[i];
      }
    }
    return Math.max(evenCount, oddCount);
  }

  public static void main(String[] args){
    int[] num = {2,7,9,3,1};
      System.out.println(get(num));
  }
}
