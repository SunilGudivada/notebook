package geeksForGeeks.dynamicProgramming;

/**
 * You have an infinite supply of coins, each having some value. Find out the number of ways to use
 * the coins to sum-up to a certain required value.
 *
 * <p>Example 1:
 *
 * <p>Input: value = 4 numberOfCoins = 3 coins[] = {1,2,3} Output: 4 Explanation: We need to make
 * the change for value = 4. The denominations are {1,2,3} Change for 4 can be made: 1+1+1+1 1+1+2
 * 1+3 2+2 So, as it is evident, we can do this in 4 ways. Example 2:
 *
 * <p>Input: value = 10 numberOfCoins = 4 coins[] = {2,5,3,6} Output: 5 Your Task: This is a
 * function problem where you've to complete the funcion numberOfWays (). You are given an amount
 * denoted by value. You are also given an array of coins. The array contains the denominations of
 * the given coins. You need to return the number of ways you can make the change for value using
 * the coins of given denominations. Also, keep in mind that you have an infinite supply of coins.
 * Note: Try not to editing the part of the code provided to you in the function. Just complete the
 * function as it has been described.
 *
 * <p>Expected Time Complexity: O(Number of Coins * Value). Expected Auxiliary Space: O(Value).
 *
 * <p>Constraints: 1 <= value <= 10^3 1 <= numberOfCoins <= 10^3 1 <= coins[i] <= 1000
 */
public class CoinChange_NumberofWays {

  long numberOfWaysdistinct(int[] coins, int numberOfCoins, int value) {
    long[][] dp = new long[value + 1][numberOfCoins + 1];
    for (int i = 0; i <= numberOfCoins; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i <= value; i++) {
      dp[i][0] = 0;
    }
    for (int i = 1; i <= value; i++) {
      for (int j = 1; j <= numberOfCoins; j++) {
        dp[i][j] = dp[i][j - 1];
        if (coins[j - 1] <= i) dp[i][j] += dp[i - coins[j - 1]][j];
      }
    }
    return dp[value][numberOfCoins];
  }

  // duplicates
  public long numberOfWays(int[] coins, int numberOfCoins, int value) {
    long[][] dp = new long[numberOfCoins + 1][value + 1];
    for (int i = 0; i <= numberOfCoins; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= value; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i <= numberOfCoins; i++) {
      for (int j = 1; j <= value; j++) {
        dp[i][j] = dp[i - 1][j];
        if (coins[i - 1] <= j) {
          dp[i][j] += dp[i][j - coins[i - 1]];
        }
      }
    }

    return dp[numberOfCoins][value];
  }

  public static void main(String[] args) {
    int[] coins = new int[] {1, 2, 3};
    int value = 4;
    CoinChange_NumberofWays obj = new CoinChange_NumberofWays();
    System.out.println(obj.numberOfWaysdistinct(coins, coins.length, value));
  }
}
