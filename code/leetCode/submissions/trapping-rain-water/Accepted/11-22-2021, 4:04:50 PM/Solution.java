// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res =0;
        int l =1, r = height.length-2, lmax = height[0], rmax = height[height.length -1];
        
        while(l <= r){
            if(lmax < rmax){
                if(height[l] >= lmax){
                    lmax = Math.max(height[l], lmax);
                }else{
                    res +=lmax - height[l];
                }
                l++;
            }else{
               if(height[r] >= rmax){
                   rmax = Math.max(height[r], rmax);
               }else{
                   res+=rmax-height[r];
               }
                r--;
            }
        }
        
        return res;
    }
}