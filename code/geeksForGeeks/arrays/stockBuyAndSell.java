package geeksForGeeks.arrays;

/**
 * Stock buy and sell Medium Accuracy: 39.53% Submissions: 20576 Points: 4 The cost of stock on each
 * day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so
 * that in between those days your profit is maximum.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 7 A[] = {100,180,260,310,40,535,695} Output: (0 3) (4 6) Explanation: We can buy
 * stock on day 0, and sell it on 3rd day, which will give us maximum profit. Now, we buy stock on
 * day 4 and sell it on day 6. Example 2:
 *
 * <p>Input: N = 5 A[] = {4,2,2,2,4} Output: (3 4) Explanation: We can buy stock on day 3, and sell
 * it on 4th day, which will give us maximum profit. Your Task: The task is to complete the function
 * stockBuySell() which takes an array price[] and N as a parameter and finds the days of buying and
 * selling stock and print them. And if there is no profit then print "No Profit". The newline is
 * automatically added by the driver code.
 *
 * <p>Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
 *
 * <p>Expected Time Complexity : O(N) Expected Auxiliary Space: O(N)
 *
 * <p>Constraints: 2 <= N <= 10^3 0 <= Ai <= 10^4
 */
public class stockBuyAndSell {

  static void stockBuySell(int price[], int n) {

    int buy_day = 0, sell_day = n-1;
    int MIN_VALUE = price[n-1];
    StringBuilder str = new StringBuilder();
    for (int i = n-1; i  > 0 ; i--) {
      if(price[i] < MIN_VALUE){
        MIN_VALUE = price[i];
        buy_day = i;
        str.append("("+sell_day+" "+buy_day+") ");
      }else{

      }
    }
    System.out.println(str);
  }

  public static void main(String[] args) {
    int A[] = {100,180,260,310,40,535,695};

    stockBuySell(A, A.length);
  }
}
