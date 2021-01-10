package geeksForGeeks.bits;

/**
 * Sum of Digits of a Number You are given a number n. You need to find the sum of digits of n.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 1 Output: 1 Explanation: Sum of digit of 1 is 1. Example 2:
 *
 * <p>Input: n = 99999 Output: 45 Explanation: Sum of digit of 99999 is 45. Your Task: You don't
 * need to read input or print anything. Your task is to complete the function sumOfDigits() that
 * takes n as parameter and returns the sum of digits of n.
 *
 * <p>Expected Time Complexity: O(Logn). Expected Auxiliary Space: O(Logn) (Recursive).
 *
 * <p>Constraints: 1 <= n <= 10^7
 */
public class sumOfDigits {
  static int sum(int n) {
    if (n < 10) return n;
    return n % 10 + sum(n / 10);
  }

  public static void main(String[] args) {
    System.out.println(sum(999));
  }
}
