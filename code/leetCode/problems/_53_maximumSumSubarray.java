package leetCode.problems;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * <p>Follow up: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has the largest sum =
 * 6. Example 2:
 *
 * <p>Input: nums = [1] Output: 1 Example 3:
 *
 * <p>Input: nums = [0] Output: 0 Example 4:
 *
 * <p>Input: nums = [-1] Output: -1 Example 5:
 *
 * <p>Input: nums = [-2147483647] Output: -2147483647
 *
 * <p>Constraints:
 *
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class _53_maximumSumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums.length < 1) return 0;
    if (nums.length == 1) return nums[0];

    int currSum=0;
    int maxSum=Integer.MIN_VALUE;

    for(int num : nums){
      currSum += num;
      if(num > currSum) currSum=num;
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    _53_maximumSumSubarray obj = new _53_maximumSumSubarray();
    System.out.println(obj.maxSubArray(new int[]{1,2,4,8}));
  }
}
