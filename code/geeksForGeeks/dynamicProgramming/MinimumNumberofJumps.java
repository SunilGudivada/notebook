package geeksForGeeks.dynamicProgramming;

/**
 * Given an array of integers where each element represents the max number of steps that can be made
 * forward from that element. The task is to find the minimum number of jumps to reach the end of
 * the array (starting from the first element). If an element is 0, then cannot move through that
 * element.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 11 a[] = {1,3,5,8,9,2,6,7,6,8,9} Output: 3 Explanation: First jump from 1st
 * element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value
 * 9. and from here we will jump to last. Example 2:
 *
 * <p>Input: N = 6 a[] = {1,4,3,2,6,7} Output: 2 Your Task: Complete the function minimumJump()
 * which takes an array and N (number of elements) as input parameters and returns the answer(if no
 * answer possible return -1)
 *
 * <p>Expected Time Complexity : O(N) Expected Auxiliary Space: O(N)
 *
 * <p>Constraints: 1 ≤ N ≤ 10^7 0 <= a[i] <= 10^7
 */
public class MinimumNumberofJumps {

  public int minimumJumps(int[] arr, int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    if (arr[0] == 0) return -1;
    for (int i = 1; i <= n; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] + j >= i) {
          if (dp[j] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], dp[j] + 1);
          }
        }
      }
    }
    return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
  }

  public static void main(String[] args) {
    MinimumNumberofJumps obj = new MinimumNumberofJumps();
    int N = 11;
    int[] a = new int[]{1,3,5,8,9,2,6,7,6,8,9};

    System.out.println(obj.minimumJumps(a, N));
  }
}
