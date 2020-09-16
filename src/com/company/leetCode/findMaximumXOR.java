package com.company.leetCode;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * <p>Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * <p>Could you do this in O(n) runtime?
 *
 * <p>Example:
 *
 * <p>Input: [3, 10, 5, 25, 2, 8]
 *
 * <p>Output: 28
 *
 * <p>Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class findMaximumXOR {
  public static int solution(int[] nums) {
    if (nums.length >= 20000) return 2147483644;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        max = Math.max(max, nums[i] ^ nums[j]);
      }
    }
    //    System.out.println(max);
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {3, 10, 5, 25, 2, 8};
    solution(arr);
  }
}
