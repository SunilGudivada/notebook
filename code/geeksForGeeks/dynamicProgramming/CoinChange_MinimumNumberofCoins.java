package geeksForGeeks.dynamicProgramming;

/**
 * You are given an amount denoted by value. You are also given an array of coins. The array
 * contains the denominations of the give coins. You need to find the minimum number of coins to
 * make the change for value using the coins of given denominations. Also, keep in mind that you
 * have infinite supply of the coins.
 *
 * <p>Example 1:
 *
 * <p>Input: value = 5 numberOfCoins = 3 coins[] = {3,6,3} Output: Not Possible Explanation:We need
 * to make the change for value = 5 The denominations are {3,6,3} It is certain that we cannot make
 * 5 using any of these coins. Example 2:
 *
 * <p>Input: value = 10 numberOfCoins = 4 coins[] = {2 5 3 6} Output: 2 Explanation:We need to make
 * the change for value = 10 The denominations are {2,5,3,6} We can use two 5 coins to make 10. So
 * minimum coins are 2. Your Task: You only need to complete the function minimumNumberOfCoins()
 * that take array of coins, size of array, and value as parameters. You need to return the minimum
 * number of coins required. If it is not possible to make the exact value out of the given coin
 * denominations, return -1 ("Not Possible" will be printed by the driver's code in this case).
 *
 * <p>Expected Time Complexity: O(N*V). Expected Auxiliary Space: O(V)
 *
 * <p>Constraints: 1 <= value <= 10^3 1 <= numberOfCoins <= 10^3 1 <= coins[i] <= 1000
 */
public class CoinChange_MinimumNumberofCoins {
  public long minimumNumberOfCoins(int[] coins, int numberOfCoins, int value) {
    long[] dp = new long[value + 1];
    dp[0] = 0;
    for (int i = 0; i <= value; i++) {
      dp[i] = value + 1;
    }
    for (int i = 1; i <= value; i++) {
      for (int j = 0; j < numberOfCoins; j++) {
        if (coins[j] <= i) {
          long sub_res = dp[i - coins[j]];
          if (sub_res != -1) {
            dp[i] = Math.min(dp[i], sub_res + 1);
          }
        }
      }
    }
    if (dp[value] == value + 1) {
      return -1;
    }
    return dp[value];
  }

  public static void main(String[] args) {
    int[] coins = new int[] {3, 6, 3};
    int value = 5;
    CoinChange_MinimumNumberofCoins obj = new CoinChange_MinimumNumberofCoins();
    System.out.println(obj.minimumNumberOfCoins(coins, coins.length, value));
  }
}
