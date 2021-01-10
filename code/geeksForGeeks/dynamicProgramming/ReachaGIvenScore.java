package geeksForGeeks.dynamicProgramming;

/**
 * Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n,
 * find the number of distinct combinations to reach the given score.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 8 Output: 1 Explanation:when n = 8,{3,5} and {5,3} are the two possible
 * permutations but these represent the same cobmination. Hence output is 1. Example 2:
 *
 * <p>Input: n = 20 Output: 4 Explanation:When n = 20, {10,10}, {5,5,5,5},{10,5,5} and {3,3,3,3,3,5}
 * are different possible permutations. Hence output will be 4. Your Task: Complete count() function
 * which takes N as an argument and returns the number of ways/combinations to reach the given
 * score.
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(N).
 *
 * <p>Constraints: 1 ≤ n ≤ 1000
 */
public class ReachaGIvenScore {
  int count(int n) {
    int[] ways = new int[] {3, 5, 10};
    int[][] dp = new int[n + 1][4];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i <= ways.length; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < 4; j++) {
        dp[i][j] = dp[i][j - 1];
        if (ways[j - 1] <= i) {
          dp[i][j] += dp[i - ways[j - 1]][j];
        }
      }
    }

    return dp[n][3];
  }

  public static void main(String[] args) {
    ReachaGIvenScore obj = new ReachaGIvenScore();
    System.out.println(obj.count(8));
  }
}
