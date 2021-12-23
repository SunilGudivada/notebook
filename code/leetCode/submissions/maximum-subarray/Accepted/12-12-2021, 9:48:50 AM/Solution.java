// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum< 0) sum =0;
        }
        return maxSum;
    }
}