package leetCode.problems;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * <p>The robot can only move either down or right at any point in time. The robot is trying to
 * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * <p>Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * <p>An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * <p>Example 1:
 *
 * <p>Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] Output: 2 Explanation: There is one obstacle
 * in the middle of the 3x3 grid above. There are two ways to reach the bottom-right corner: 1.
 * Right -> Right -> Down -> Down 2. Down -> Down -> Right -> Right Example 2:
 *
 * <p>Input: obstacleGrid = [[0,1],[0,0]] Output: 1
 *
 * <p>Constraints:
 *
 * <p>m == obstacleGrid.length n == obstacleGrid[i].length 1 <= m, n <= 100 obstacleGrid[i][j] is 0
 * or 1.
 */
public class _63_uniquePaths2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if(obstacleGrid[m-1][n-1] == 1){
      return 0;
    }

    int dp[][] = new int[m + 1][n + 1];
    dp[1][1] = 1;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (i + 1 <= m && obstacleGrid[i-1][j-1]!=1) {
          dp[i + 1][j] += dp[i][j];
        }
        if (j + 1 <= n && obstacleGrid[i-1][j-1]!=1) {
          dp[i][j + 1] += dp[i][j];
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    _63_uniquePaths2 obj = new _63_uniquePaths2();
    int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
    System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
  }
}
