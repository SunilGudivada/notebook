package geeksForGeeks.bits;

/**
 * Swap all odd and even bits Given an unsigned integer N. The task is to swap all odd bits with
 * even bits. For example, if the given number is 23 (00010111), it should be converted to
 * 43(00101011). Here, every even position bit is swapped with adjacent bit on the right side(even
 * position bits are highlighted in the binary representation of 23), and every odd position bit is
 * swapped with an adjacent on the left side.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 23 Output: 43 Explanation: Binary representation of the given number is 00010111
 * after swapping 00101011 = 43 in decimal. Example 2:
 *
 * <p>Input: N = 2 Output: 1 Explanation: Binary representation of the given number is 10 after
 * swapping 01 = 1 in decimal.
 *
 * <p>Your Task: Your task is to complete the function swapBits() which takes an integer and returns
 * an integer with all the odd and even bits swapped.
 *
 * <p>Expected Time Complexity: O(log N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 1 ≤ N ≤ 10^9
 */
public class swapBits {

  static int swapEvenAndOdd(int n) {
    int even_bits = n & 0xAAAAAAAA;

    int odd_bits = n & 0x55555555;

    even_bits >>= 1;

    odd_bits <<= 1;

    return (even_bits | odd_bits);
  }

  public static void main(String[] args) {
    System.out.println(swapEvenAndOdd(23));  //43
    System.out.println(swapEvenAndOdd(2)); //1
  }
}
