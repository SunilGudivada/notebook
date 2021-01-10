package geeksForGeeks.bits;

/**
 * Bit Difference You are given two numbers A and B. The task is to count the number of bits needed
 * to be flipped to convert A to B.
 *
 * <p>Example 1:
 *
 * <p>Input: A = 10, B = 20 Output: 4 Explanation: A = 01010 B = 10100 As we can see, the bits of A
 * that need to be flipped are 01010. If we flip these bits, we get 10100, which is B. Example 2:
 *
 * <p>Input: A = 20, B = 25 Output: 3 Explanation: A = 10100 B = 11001 As we can see, the bits of A
 * that need to be flipped are 10100. If we flip these bits, we get 11001, which is B.
 *
 * <p>Your Task: The task is to complete the function countBitsFlip() that takes A and B as
 * parameters and returns the count of the number of bits to be flipped to convert A to B.
 *
 * <p>Expected Time Complexity: O(log N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 1 ≤ A, B ≤ 10^6
 */
public class countBitsFlip {
  static int solution(int a, int b) {
    int two_mul = 2;
    int count = 0;
    while (a > 0 || b > 0) {
      if (a % two_mul != b % two_mul) {
        count++;
      }
      a = a >> 1;
      b = b >> 1;
    }
//    while (a > 0) {
//      a = a >> 1;
//      count++;
//    }
//    while (b > 0) {
//      b = b >> 1;
//      count++;
//    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(solution(20, 25)); // 3
    System.out.println(solution(10, 20)); // 4
  }
}
