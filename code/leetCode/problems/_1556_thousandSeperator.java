/** https://leetcode.com/contest/biweekly-contest-33/problems/thousand-separator/
 *
 * Using StringBuilder ( insert function to insert by provding the index to be added ( "." )
 * */
package leetCode.problems;

/**
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 987 Output: "987" Example 2:
 *
 * <p>Input: n = 1234 Output: "1.234" Example 3:
 *
 * <p>Input: n = 123456789 Output: "123.456.789" Example 4:
 *
 * <p>Input: n = 0 Output: "0"
 *
 * <p>Constraints:
 *
 * <p>0 <= n < 2^31
 */
public class _1556_thousandSeperator {
  public static String dotSeperator(int n) {
    StringBuilder sb = new StringBuilder().append(n);
    if (sb.length() < 4) return sb.toString();
    for (int i = sb.length() - 3; i > 0; i -= 3) {
      sb.insert(i, ".");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(dotSeperator(1234567));
  }
}
