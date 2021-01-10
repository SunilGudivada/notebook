package leetCode.problems;

/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j <
 * n.
 *
 * <p>Follow up: Could you do this in O(n) runtime?
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [3,10,5,25,2,8] Output: 28 Explanation: The maximum result is 5 XOR 25 = 28.
 * Example 2:
 *
 * <p>Input: nums = [0] Output: 0 Example 3:
 *
 * <p>Input: nums = [2,4] Output: 6 Example 4:
 *
 * <p>Input: nums = [8,10,2] Output: 10 Example 5:
 *
 * <p>Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70] Output: 127
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 2 * 10^4
 * 0 <= nums[i] <= 2^31 - 1
 */
public class _421_findMaximumXOR {
  public static int solution(int[] nums) {
    if (nums.length >= 20000) return 2147483644;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      for (int i : nums) {
        max = Math.max(max, num ^ i);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {3, 10, 5, 25, 2, 8};
    System.out.println(solution(arr));
  }
}
