package geeksForGeeks.recursion;

/**
 * Count Total Digits in a Number You are given a number n. You need to find the count of digits in
 * n.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 1 Output: 1 Explanation: Number of digit in 1 is 1. Example 2:
 *
 * <p>Input: n = 99999 Output: 5 Explanation:Number of digit in 99999 is 5 Your Task: You don't need
 * to read input or print anything. Your task is to complete the function countDigits() that takes n
 * as parameter and returns the count of digits in n.
 *
 * <p>Expected Time Complexity: O(Logn). Expected Auxiliary Space: O(Logn).
 *
 * <p>Constraints: 0 <= n <= 10^7
 */
public class countDigits {
  static int count(int n){
    if(n<10) return 1;
    return 1+ count(n/10);
  }
  public static void main(String[] args) {
    System.out.println(count(999));
  }
}
