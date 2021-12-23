// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int l =0, res=0, r=height.length -1, level = 0;
        while(l < r ){
            int lower = height [ height[l] < height[r] ? l++ : r--];
            level = Math.max(level,lower);
            res+=level-lower;
        }
        return res;
    }
}