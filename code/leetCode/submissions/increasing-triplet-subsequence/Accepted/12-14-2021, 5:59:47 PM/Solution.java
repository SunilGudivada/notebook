// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] smallest = new int[n];
        int[] highest = new int[n];
        
        smallest[0] = Integer.MAX_VALUE;
        
        for(int i=1;i<n;i++){
            smallest[i] = Math.min(smallest[i-1], nums[i-1]);
        }
        
        highest[n-1] = Integer.MIN_VALUE;
        for(int i = n-2;i>0;i--){
            highest[i] = Math.max(highest[i+1], nums[i+1]);
        }
        
        for(int i=1;i<n-1;i++){
            if(smallest[i] < nums[i] && highest[i] > nums[i]){
                return true;
            }
        }
        return false;
    }
}