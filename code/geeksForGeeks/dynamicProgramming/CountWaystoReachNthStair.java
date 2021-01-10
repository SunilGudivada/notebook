package geeksForGeeks.dynamicProgramming;

/**
 * There are N stairs, a person standing at the bottom wants to reach the top. The person can climb
 * either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top
 * (order does matter).
 *
 * <p>Example 1:
 *
 * <p>Input: N = 4 Output: 5 Explanation: You can reach 4th stair in 5 ways. Example 2:
 *
 * <p>Input: N = 10 Output: 89 Your Task: Complete the function countWays() which takes the top
 * stair number m as input parameters and returns the answer % 10^9+7.
 *
 * <p>Expected Time Complexity : O(N) Expected Auxiliary Space: O(1)
 *
 * <p>Constraints: 1 <= N <= 10^5
 */
public class CountWaystoReachNthStair {

  // order Does Not matter
  long countWays(int m) {
    Long[] dp = new Long[m + 1];
    dp[0] = 1L;
    dp[1] = 1L;
    if (m <= 1) {
      return m;
    }
    for (int i = 2; i <= m; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    }
    return dp[m];
  }

  long distinctCountWays(int m) {
    long[] dp = new long[m + 1];
    dp[0] = 1;

    for (int i = 1; i <= m; i++) {
      dp[i] += dp[i - 1];
      System.out.print(dp[i]+" ");
    }
    System.out.print(dp[1]+" ");
    for (int i = 2; i <= m; i++) {
      dp[i] += dp[i - 2];
      System.out.print(dp[i]+" ");
    }
    return dp[m];
  }

  public static void main(String[] args) {
    CountWaystoReachNthStair obj = new CountWaystoReachNthStair();
    System.out.println(obj.countWays(4));
    System.out.println(obj.distinctCountWays(8));
  }
}
