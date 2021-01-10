package leetCode.problems;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else
 * False.
 *
 * <p>Follow up: Do not use any built-in library function such as sqrt.
 *
 * <p>Example 1:
 *
 * <p>Input: num = 16 Output: true Example 2:
 *
 * <p>Input: num = 14 Output: false
 *
 * <p>Constraints:
 *
 * <p>1 <= num <= 2^31 - 1
 */
public class _367_ValidPerfectSquare {
  public boolean isPerfectSquare(int x) {
    int low = 0, high = x;

    while (low <= high) {
      long mid = low + (high - low) / 2;

      if (mid * mid == x) {
        return true;
      } else if (mid * mid > x) {
        high = (int) mid - 1;
      } else {
        low = (int) mid + 1;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    _367_ValidPerfectSquare obj = new _367_ValidPerfectSquare();
    System.out.println(obj.isPerfectSquare(36));
  }
}
