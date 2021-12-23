// https://leetcode.com/problems/consecutive-characters

class Solution {
    public int maxPower(String s) {
        
        int index = 0;
        int max = Integer.MIN_VALUE;
        if(s.length() == 1) return 1;
        
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) != s.charAt(i+1)){
                index = i;
            }
            max = Math.max(i-index+1,max);
        }
        
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}