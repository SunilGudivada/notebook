package leetCode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>You can return the answer in any order.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 *
 * Example 2:
 *
 * <p>Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 *
 * Example 3:
 *
 * <p>Input: nums = [3,3], target = 6 Output: [0,1]
 *
 * <p>Constraints:
 *
 * <p>2 <= nums.length <= 103 -109 <= nums[i] <= 109 -109 <= target <= 109 Only one valid answer
 * exists.
 */
public class _1_TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] {map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
  public static void main(String... args) {
    int nums[] = {2,7,11,15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }
}