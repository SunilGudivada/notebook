package geeksForGeeks.bits;

/**
 * Longest Consecutive 1's Given a number N. The task is to find the length of the longest
 * consecutive 1s in its binary representation.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 14 Output: 3 Explanation: Binary representation of 14 is 1110, in which 111 is the
 * longest consecutive set bits of length is 3. Example 2:
 *
 * <p>Input: N = 222 Output: 4 Explanation: Binary representation of 222 is 11011110, in which 1111
 * is the longest consecutive set bits of length 4.
 *
 * <p>Your Task: The task is to complete the function maxConsecutiveOnes() which returns the length
 * of the longest consecutive 1s in the binary representation of given N.
 *
 * <p>Expected Time Complexity: O(log N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 1 <= N <= 106
 */
public class maxConsecutiveOnes {
  static int get(int n) {
    int count = 0;
    int max = Integer.MIN_VALUE;
    while (n > 0) {
      if ((n & 1) == 1) {
        count++;
        max = Math.max(count, max);
      }else{
        count =0;
      }
      n = n >> 1;
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(get(14)); // 3
    System.out.println(get(222)); // 222
  }
}
