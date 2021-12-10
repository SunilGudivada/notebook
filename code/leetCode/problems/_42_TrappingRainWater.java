package leetCode.problems;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class _42_TrappingRainWater {
  // O(n^2)
  public int trap(int[] height) {
    int sum = 0;
    for (int i = 0; i < height.length; i++) {
      int left = leftMax(height, i);
      int right = rightMax(height, i);
      sum = sum + Math.min(left, right) - height[i];
    }
    return sum;
  }

  private int leftMax(int[] height, int index) {
    int res = height[index];
    for (int i = 0; i < index; i++) {
      res = Math.max(res, height[i]);
    }
    return res;
  }

  private int rightMax(int[] height, int index) {
    int res = height[index];
    for (int i = index + 1; i < height.length; i++) {
      res = Math.max(res, height[i]);
    }
    return res;
  }

  // O(n) - Time, O(1) - Space
  public int trap2(int[] arr) {
    int n = arr.length;
    int result = 0;

    int left_max = 0, right_max = 0;
    int lo = 0, hi = n - 1;
    while (lo <= hi) {
      if (arr[lo] < arr[hi]) {
        if (arr[lo] > left_max) left_max = arr[lo];
        else result += left_max - arr[lo];
        lo++;
      } else {
        if (arr[hi] > right_max) right_max = arr[hi];
        else result += right_max - arr[hi];
        hi--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    _42_TrappingRainWater obj = new _42_TrappingRainWater();
    int[] arr = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6
    int[] arr1 = new int[] {4, 2, 0, 3, 2, 5}; // 9
    System.out.println(obj.trap(arr));
    System.out.println(obj.trap(arr1));
  }
}
