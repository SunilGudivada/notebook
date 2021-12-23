// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        
        int maxLength = 0;
        String t = "";
        
        for(char c:s.toCharArray()){
            String current = String.valueOf(c);
            if(t.contains(current)){
                t = t.substring(t.indexOf(current)+1);
            }
            t += current;
            maxLength = Math.max(maxLength, t.length());
        }
        return maxLength;
    }
}