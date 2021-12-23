// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        if(nums[0] >= nums.length) return 1;
        int maxReach = nums[0];
        int steps = nums[0];
        int jumps =0;
        
        for(int i=1;i<nums.length;i++){
            maxReach = Math.max(maxReach, nums[i]+i);
            steps--;
            if(steps == 0){
                jumps++;
                steps = maxReach - i;
            }
        }
        
        return jumps;
    }
}