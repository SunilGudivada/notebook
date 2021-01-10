package geeksForGeeks.dynamicProgramming;

import java.math.BigInteger;

/**
 * Given a number N. The task is to find the Nth catalan number. The first few Catalan numbers for N
 * = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, … Note: Positions start from 0 as
 * shown above.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 5 Output: 42 Example 2:
 *
 * <p>Input: N = 4 Output: 14 Your Task: Complete findCatalan() function that takes n as an argument
 * and returns the Nth Catalan number. The output is printed by the driver code.
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(N).
 *
 * <p>Constraints: 1 <= N <= 100
 */
public class FindCatalan {
  BigInteger findNthCatalan(int n) {
    BigInteger[] dp = new BigInteger[n + 1];
    dp[0] = BigInteger.ONE;
    dp[1] = BigInteger.ONE;
    for (int i = 2; i <= n; ++i) {
      dp[i] = BigInteger.ZERO;
      for (int j = 0, k = i - 1; j < i; ++j, --k) dp[i] = dp[i].add(dp[j].multiply(dp[k]));
    }
    return dp[n];
  }

  public static void main(String[] args) {
    FindCatalan obj = new FindCatalan();
    System.out.println(obj.findNthCatalan(5));
  }
}
