// https://leetcode.com/problems/binary-search

class Solution {
    
    public int binarySearch(int l, int r, int[] nums, int target){
        
        if( l == r ){
            return -1;
        }
        int m =  (l + r) / 2;

        if(nums[m] == target){
            return m;
        }
        if(nums[m] > target){
            return binarySearch(l, m, nums, target);
        }else{
            return binarySearch(m+1, r, nums, target);
        }
        
    }
    
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        return binarySearch(leftIndex, rightIndex, nums, target);
    }
}