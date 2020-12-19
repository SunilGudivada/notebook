package com.platform.leetCode.problems.dp;

public class _1143_LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    char str1[] = text1.toCharArray();
    char str2[] = text2.toCharArray();

    int dp[][] = new int[str1.length+1][str2.length+1];

    for(int i = 1;i<=str1.length;i++){
      for(int j = 1;j<=str2.length;j++){
        if(str1[i-1] == str2[j-1]){
          dp[i][j] = 1 + dp[i-1][j-1];
        }
        else
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
      }
    }

    return dp[str1.length ][str2.length];
  }

  public static void main(String[] args) {
    _1143_LongestCommonSubsequence obj = new _1143_LongestCommonSubsequence();
    System.out.println(obj.longestCommonSubsequence("bbbab", "babbb"));
  }
}
