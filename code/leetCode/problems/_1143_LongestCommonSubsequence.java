package leetCode.problems;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * <p>A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
 * is a subsequence that is common to both strings.
 *
 * <p>If there is no common subsequence, return 0.
 *
 * <p>Example 1:
 *
 * <p>Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The longest common subsequence is
 * "ace" and its length is 3. Example 2:
 *
 * <p>Input: text1 = "abc", text2 = "abc" Output: 3 Explanation: The longest common subsequence is
 * "abc" and its length is 3. Example 3:
 *
 * <p>Input: text1 = "abc", text2 = "def" Output: 0 Explanation: There is no such common
 * subsequence, so the result is 0.
 *
 * <p>Constraints:
 *
 * <p>1 <= text1.length <= 1000 1 <= text2.length <= 1000 The input strings consist of lowercase
 * English characters only.
 */
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
