// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        
        int max = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for(int i=0;i< nums.length;i++){
            int left = 0;
            int right = 0;
            int currentNumber = nums[i];
            currentNumber--;
            while(set.contains(currentNumber)){
                left++;
                currentNumber--;
            }
            
            currentNumber = nums[i] + 1;
            
            while(set.contains(currentNumber)){
                right++;
                currentNumber++;
            }
            
            set.add(nums[i]);
            max = Math.max(max, left+right+1);
        }
        
        return max;
    }
}