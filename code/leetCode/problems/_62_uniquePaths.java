package leetCode.problems;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * <p>The robot can only move either down or right at any point in time. The robot is trying to
 * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * <p>How many possible unique paths are there?
 *
 * <p>Example 1:
 *
 * <p>Input: m = 3, n = 7 Output: 28 Example 2:
 *
 * <p>Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there are a total of 3
 * ways to reach the bottom-right corner: 1. Right -> Down -> Down 2. Down -> Down -> Right 3. Down
 * -> Right -> Down Example 3:
 *
 * <p>Input: m = 7, n = 3 Output: 28 Example 4:
 *
 * <p>Input: m = 3, n = 3 Output: 6
 *
 * <p>Constraints:
 *
 * <p>1 <= m, n <= 100 It's guaranteed that the answer will be less than or equal to 2 * 10^9.
 */
public class _62_uniquePaths {
  public int uniquePaths(int m, int n) {
    int dp[][] = new int[m + 1][n + 1];
    dp[1][1] = 1;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (i + 1 <= m) {
          dp[i + 1][j] += dp[i][j];
        }
        if (j + 1 <= n) {
          dp[i][j + 1] += dp[i][j];
        }
      }
    }
//    for (int i = 0; i <= m; i++) {
//      for (int j = 0; j <= n; j++) {
//        System.out.print(dp[i][j] + " ");
//      }
//      System.out.println();
//    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    _62_uniquePaths obj = new _62_uniquePaths();
    System.out.println(obj.uniquePaths(3, 2));
  }
}
