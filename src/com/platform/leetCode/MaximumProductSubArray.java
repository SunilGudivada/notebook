package com.platform.leetCode;

public class MaximumProductSubArray {

  public static int get(int[] nums){
    int product = 1;
    int maxProduct = Integer.MIN_VALUE;

    for(int i=0;i<nums.length;i++){
      product *=nums[i];
      maxProduct = Math.max(maxProduct,product);
      if(product == 0){
        product = 1;
      }
    }
    product = 1;
    for(int i= nums.length-1;i>=0;i--){
      product *=nums[i];
      maxProduct = Math.max(maxProduct,product);
      if(product == 0){
        product = 1;
      }
    }
    return maxProduct;
  }

  public static void main(String[] args){
    int[] nums = {3, -1, 4};
    System.out.println(get(nums));

  }
}
