package leetCode.problems;

public class _887_SuperEggDrop {

  public int superEggDrop(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    int m = 0;
    while (dp[n][m] < k) {
      m += 1;
      for (int egg = 1; egg <= n; egg++) {
        dp[egg][m] = dp[egg][m - 1] + dp[egg - 1][m - 1] + 1;
      }
    }
    return m;
  }


  // Time Limit exceeding
  int superEggDrop2(int n, int k) {

    int dp[][] = new int[n + 1][k + 1];
    int res = -1;

    for (int i = 1; i <= n; i++) {
      dp[i][1] = 1;
      dp[i][0] = 0;
    }

    for (int j = 1; j <= k; j++) dp[1][j] = j;

    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= k; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int x = 1; x <= j; x++) {
          res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
          if (res < dp[i][j]) dp[i][j] = res;
        }
      }
    }

    return dp[n][k];
  }

  public static void main(String[] args) {
    _887_SuperEggDrop obj = new _887_SuperEggDrop();
    System.out.println(obj.superEggDrop(2,1));
    System.out.println(obj.superEggDrop(14,3));
  }
}
