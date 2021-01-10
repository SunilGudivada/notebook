package leetCode.problems;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * <p>A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of
 * the array [0,3,1,6,2,2,7].
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing subsequence
 * is [2,3,7,101], therefore the length is 4. Example 2:
 *
 * <p>Input: nums = [0,1,0,3,2,3] Output: 4 Example 3:
 *
 * <p>Input: nums = [7,7,7,7,7,7,7] Output: 1
 *
 * <p>Constraints:
 *
 * <p>
 *   1 <= nums.length <= 2500
 *   -10^4 <= nums[i] <= 10^4
 *
 * <p>Follow up:
 *
 *   Could you come up with the O(n^2) solution?
 *   Could you improve it to O(n log(n)) time complexity?
 *
 */
public class _300_longestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = 1;
    int res = lis[0];
    for (int i = 1; i < n; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          lis[i] = Math.max(lis[i], 1 + lis[j]);
        }
      }
      res = Math.max(res, lis[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    _300_longestIncreasingSubsequence obj = new _300_longestIncreasingSubsequence();
    System.out.println(obj.lengthOfLIS(new int[] {3, 4, 2, 8, 10, 5, 1}));
  }
}
