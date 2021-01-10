package geeksForGeeks.dynamicProgramming;

/**
 * Find nCr for given n and r.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 3, r = 2 Output: 3 Example 2:
 *
 * <p>Input: n = 4, r = 2 Output: 6 Your Task: Complete the function nCrModpâ€‹() which takes two
 * integers n and r as input parameters and returns the nCr mod 109+7. Note: nCr does not exist when
 * r > n. Hence, return 0 in that case.
 *
 * <p>Expected Time Complexity : O(N*R) Expected Auxiliary Space: O(N)
 *
 * <p>Constraints: 1<= n <= 10^3 1<= r <= 10^3
 */
public class nCr {
  public static int nCrModp(int n, int r) {
    int[][] dp = new int[n + 1][n + 1];

    if (r > n) {
      return 0;
    }

    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = 0;

        if (j >= 0 && j < i) {
          dp[i][j] = (dp[i][j] + dp[i - 1][j]) % 1000000007;
        }

        if (j - 1 >= 0 && j - 1 < i) {
          dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
        }
      }
    }

    return dp[n][r];
  }

  public static void main(String[] args) {
    System.out.println(nCrModp(3, 2));
  }
}
