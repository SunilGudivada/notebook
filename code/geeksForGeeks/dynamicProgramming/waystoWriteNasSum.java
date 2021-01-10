package geeksForGeeks.dynamicProgramming;

/**
 * Given a positive integer N, the task is to find the number of different ways in which N can be
 * written as a sum of two or more positive integers.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 5 Output: 6 Explanation: 1+1+1+1+1 1+1+1+2 1+1+3 1+4 2+1+2 2+3 So, a total of 6
 * ways. Example 2:
 *
 * <p>Input: N = 3 Output: 2 Your Task: Your task is to complete the function countWays() which
 * takes 1 argument(N) and returns the answer%(10^9 + 7).
 *
 * <p>Expected Time Complexity: O(N2) Expected Auxiliary Space: O(N)
 *
 * <p>Constraints: 1 <= N <= 10^3
 */
public class waystoWriteNasSum {
  int countWays(int n) {
    long[] arr = new long[n + 1];
    arr[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= n; j++) {
        if (j >= i) {
          arr[j] = (long) ((arr[j - i] + arr[j]) % (Math.pow(10, 9) + 7));
        }
      }
    }
    return (int) arr[n];
  }

  public static void main(String[] args) {
    waystoWriteNasSum obj = new waystoWriteNasSum();
    System.out.println(obj.countWays(5));
  }
}
