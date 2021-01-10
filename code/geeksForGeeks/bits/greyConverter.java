package geeksForGeeks.bits;

/**
 * Binary To Gray Code equivalent You are given a decimal number N. You need to find the gray code
 * of the number N and convert it into decimal. To see how it's done, refer here.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 7 Output: 4 Explanation: 7 is represented as 111 in binary form. The gray code of
 * 111 is 100, in the binary form whose decimal equivalent is 4. Example 2:
 *
 * <p>Input: N = 10 Output: 15 Explanation: 10 is represented as 1010 in binary form. The gray code
 * of 1010 is 1111, in the binary form whose decimal equivalent is 15. Example 3:
 *
 * <p>Input: N = 0 Output: 0 Explanation: Zero is represented as zero in binary, gray, and decimal.
 *
 * <p>Your Task: The task is to complete the function greyConverter() which takes n as a parameter
 * and returns it's equivalent gray code.
 *
 * <p>Expected Time Complexity: O(log N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 0 <= N <= 109
 */
public class greyConverter {

  static int convert(int n) {
    return n ^ (n >> 1);
  }

  public static void main(String[] args) {
    System.out.println(convert(7)); // 4
    System.out.println(convert(10)); // 15
  }
}
