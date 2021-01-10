package leetCode.problems;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the
 * maximum length of s is 1000.
 *
 * <p>Example 1: Input:
 *
 * <p>"bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb".
 *
 * <p>Example 2: Input:
 *
 * <p>"cbbd" Output: 2 One possible longest palindromic subsequence is "bb".
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 1000 s consists only of lowercase English letters.
 */
public class _516_longestPalindromicSubsequence {
  public int longestPalindromeSubseq(String s) {

    char[] s1 = s.toCharArray();
    int length = s.length();

    int[][] dp = new int[s1.length + 1][s1.length + 1];

    for (int i = 1; i <= length; i++) {
      for (int j = 1; j <= length; j++) {
        if (s1[i - 1] == s1[length-j]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[s1.length][s1.length];
  }

  public static void main(String[] args) {
    _516_longestPalindromicSubsequence obj = new _516_longestPalindromicSubsequence();
    System.out.println(obj.longestPalindromeSubseq("bbbab"));
  }
}
