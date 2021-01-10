package geeksForGeeks.recursion;

/**
 * Print 1 To N Without Loop Print numbers from 1 to N without the help of loops.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 10 Output: 1 2 3 4 5 6 7 8 9 10
 *
 * <p>Example 2:
 *
 * <p>Input: N = 5 Output: 1 2 3 4 5
 *
 * <p>Your Task: This is a function problem. You only need to complete the function printNos() that
 * takes N as parameter and prints number from 1 to N recursively. The driver code adds the newline
 * automatically after the function call.
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(N) (Recursive).
 *
 * <p>Constraints: 1 <= N <= 990
 */
public class printNos {
  static void print(int n) {
    if (n == 0) return;
    print(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    print(10);
  }
}
