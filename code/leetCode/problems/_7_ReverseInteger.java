package leetCode.problems;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the
 * 32-bit signed integer range: [−2^31, 2^31 − 1]. For the purpose of this problem, assume that your
 * function returns 0 when the reversed integer overflows.
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 */
public class _7_ReverseInteger {
  int reverse(int x) {
    long rev = 0, a = x;
    if (a < 0) a = -a;
    while (a > 0) {
      rev = rev * 10 + a % 10;
      a = a / 10;
    }
    if (x < 0) rev = -rev;
    if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) return 0;

    return (int) rev;
  }

  public static void main(String[] args) {
    _7_ReverseInteger obj = new _7_ReverseInteger();
    System.out.println(obj.reverse(123));
  }
}
