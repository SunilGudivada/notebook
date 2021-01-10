package leetCode.problems;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible
 * combinations that add up to a positive integer target.
 *
 * <p>Example:
 *
 * <p>nums = [1, 2, 3] target = 4
 *
 * <p>The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2)
 * (3, 1)
 *
 * <p>Note that different sequences are counted as different combinations.
 *
 * <p>Therefore the output is 7.
 *
 * <p>Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class _377_combinationSum4 {
  public int combinationSum4(int[] vals, int sum) {
    if (sum < 0) {
      return 0;
    }
    if (vals == null || vals.length == 0) {
      return 0;
    }

    int[] dp = new int[sum + 1];
    dp[0] = 1;
    for (int j = 1; j <= sum; j++) {
      for (int val : vals) {
        if (val - j <= 0) {
          dp[j] += dp[j - val];
        }
      }
    }
    return dp[sum];
  }

  public static void main(String[] args) {
    _377_combinationSum4 obj = new _377_combinationSum4();
    int[] nums = new int[] {1, 2, 3};
    int target = 4;
    System.out.println(obj.combinationSum4(nums, target));
  }
}
