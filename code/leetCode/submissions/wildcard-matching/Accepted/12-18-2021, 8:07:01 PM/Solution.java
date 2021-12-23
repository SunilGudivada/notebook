// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
        char[] pattern = p.toCharArray();
        char[] str = s.toCharArray();
        
        int writeIndex =0;
        boolean isFirst = true;
        int n = pattern.length;
        for(int i=0;i<n;i++){
            if(pattern[i] == '*'){
                if(isFirst){
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            }else{
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
        
        boolean dp[][] = new boolean[str.length+1][writeIndex + 1];
        
        if(writeIndex >0 && pattern[0] == '*'){
            dp[0][1] = true;
        }
        
        dp[0][0] = true;
        
        for(int i=1;i<str.length+1;i++){
            for(int j=1;j<writeIndex +1;j++){
                if(str[i-1] == pattern[j-1] || pattern[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern[j-1] == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } 
            }
        }
        
        return dp[str.length][writeIndex];
    }
}