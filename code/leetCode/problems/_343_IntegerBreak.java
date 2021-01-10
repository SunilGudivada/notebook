package leetCode.problems;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize
 * the product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class _343_IntegerBreak {
  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        dp[i] = Math.max(dp[i], (i - j) * j);
        dp[i] = Math.max(dp[i], dp[j] * (i - j));
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    _343_IntegerBreak obj = new _343_IntegerBreak();
    System.out.println(obj.integerBreak(35));
  }
}
