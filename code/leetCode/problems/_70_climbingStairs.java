package leetCode.problems;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the
 * top?
 *
 * <p>Example 1:
 *
 * <p>Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1 step + 1 step
 * 2. 2 steps Example 2:
 *
 * <p>Input: n = 3 Output: 3 Explanation: There are three ways to climb to the top. 1. 1 step + 1
 * step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 *
 * <p>Constraints:
 *
 * <p>1 <= n <= 45
 */
public class _70_climbingStairs {
  public int climbStairs(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2;i<=n;i++){
      dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    _70_climbingStairs obj = new _70_climbingStairs();
    System.out.println(obj.climbStairs(3));
  }
}
