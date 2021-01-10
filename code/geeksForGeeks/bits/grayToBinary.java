package geeksForGeeks.bits;

/**
 * Gray to Binary equivalent Given N in Gray code equivalent. Find its binary equivalent. Note: We
 * need to find the binary equivalent of the given gray code and return the decimal equivalent of
 * the binary representation.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 4 Output: 7 Explanation: 4 is represented as gray 100 and its binary equivalent is
 * 111 whose decimal equivalent is 7. Example 2:
 *
 * <p>Input: N = 15 Output: 10 Explanation: 15 is represented as gray 1111 and its binary equivalent
 * is 1010 i.e. 10 in decimal. Example 3:
 *
 * <p>Input: N = 0 Output: 0 Explanation: Zero is zero in gray and in binary and decimal.
 *
 * <p>Your Task: Your task is to complete the function grayToBinary() which accepts an integer n as
 * a parameter and returns decimal of the binary equivalent of the given gray number.
 *
 * <p>Expected Time Complexity: O(log N).
 * Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 0 <= N <= 10^8
 */
public class grayToBinary {
  static int convert(int n) {

    int inv = 0;

    for (; n != 0; n = n >> 1) inv ^= n;

    return inv;
  }

  public static void main(String[] args) {
    System.out.println(convert(4)); // 7
    System.out.println(convert(15)); // 10
  }
}
