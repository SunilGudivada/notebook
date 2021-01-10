package geeksForGeeks.bits;

/**
 * Power of 2 Given a positive integer N. The task is to check if N is a power of 2. More formally,
 * check if N can be expressed as 2x for some x.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 1 Output: true Explanation: 1 is equal to 2 raised to 0 (20 == 1). Example 2:
 *
 * <p>Input: N = 98 Output: false Explanation: 98 cannot be obtained by any power of 2.
 *
 * <p>Your Task: Your task is to complete the function isPowerofTwo() which takes n as a parameter
 * and returns true or false by checking is given number can be represented as a power of two or
 * not.
 *
 * <p>Expected Time Complexity: O(log N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 0 <= N <= 10^18
 */
public class isPowerofTwo {

  static boolean check(int n) {

    if(n==0) return false;

    return ((n & (n-1)) == 0);
  }

  public static void main(String[] args) {
    System.out.println(check(2));
  }
}
