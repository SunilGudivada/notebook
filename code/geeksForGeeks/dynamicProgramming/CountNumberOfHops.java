package geeksForGeeks.dynamicProgramming;

/**
 * A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top. As
 * the answer will be large find the answer modulo 1000000007.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 1 Output: 1 Example 2:
 *
 * <p>Input: N = 4 Output: 7 Explanation:Below are the 7 ways to reach 4 1 step + 1 step + 1 step +
 * 1 step 1 step + 2 step + 1 step 2 step + 1 step + 1 step 1 step + 1 step + 2 step 2 step + 2 step
 * 3 step + 1 step 1 step + 3 step Your Task: Your task is to complete the function countWays()
 * which takes 1 argument(N) and returns the answer%(10^9 + 7).
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 1 ≤ N ≤ 10^5
 */
public class CountNumberOfHops {
  public long countWays(int n) {
    if (n < 2) return n;
    if (n == 2) return 2L;
    long[] dp = new long[n + 1];
    dp[0] = 1L;
    dp[1] = 1L;
    dp[2] = 2L;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    CountNumberOfHops obj = new CountNumberOfHops();
    System.out.println(obj.countWays(8));
  }
}
