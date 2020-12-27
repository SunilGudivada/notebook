package com.platform.leetCode.problems.dp;

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
