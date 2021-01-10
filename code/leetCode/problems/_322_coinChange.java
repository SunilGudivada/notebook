package leetCode.problems;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a
 * function to compute the fewest number of coins that you need to make up that amount. If that
 * amount of money cannot be made up by any combination of the coins, return -1.
 *
 * <p>You may assume that you have an infinite number of each kind of coin.
 *
 * <p>Example 1:
 *
 * <p>Input: coins = [1,2,5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1 Example 2:
 *
 * <p>Input: coins = [2], amount = 3 Output: -1 Example 3:
 *
 * <p>Input: coins = [1], amount = 0 Output: 0 Example 4:
 *
 * <p>Input: coins = [1], amount = 1 Output: 1 Example 5:
 *
 * <p>Input: coins = [1], amount = 2 Output: 2
 *
 * <p>Constraints:
 *
 * <p>1 <= coins.length <= 12 1 <= coins[i] <= 2^31 - 1 0 <= amount <= 10^4
 */
public class _322_coinChange {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    _322_coinChange obj = new _322_coinChange();
    System.out.println(obj.coinChange(new int[] {1, 2, 3}, 4));
  }
}
