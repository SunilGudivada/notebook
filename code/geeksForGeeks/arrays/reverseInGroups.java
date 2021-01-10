package geeksForGeeks.arrays;

import java.util.ArrayList;

/**
 * Reverse array in groups Basic Accuracy: 51.16% Submissions: 16693 Points: 1 Given an array arr[]
 * of positive integers of size N. Reverse every sub-array of K group elements.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 5, K = 3 arr[] = {1,2,3,4,5} Output: 3 2 1 5 4 Explanation: Reversing groups in
 * size k = 3, first group consists of elements 1, 2, 3. Reversing this group, we have elements in
 * order as 3, 2, 1. Example 2:
 *
 * <p>Input: N = 4, K = 3 arr[] = {5,6,8,9} Output: 8 6 5 9 Explanation: Our array is 5 6 8 9. The
 * value of k is 3. So we reverse it in groups of 3. After reversing, it becomes 8 6 5 9. Your Task:
 * The task is to complete the function reverseInGroups() which reverses elements of the array in
 * groups and returns the array. The printing of array is done by drivercode.
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(N).
 *
 * <p>Constraints: 1 ≤ N, K ≤ 10^7 1 ≤ A[i] ≤ 10^18
 */
public class reverseInGroups {
  public static ArrayList<Integer> reverse(ArrayList<Integer> mv, int n, int k) {

    for (int i = 0; i < n; i += k) {

      int left = i;
      int right = Math.min(i + k - 1, n - 1);
      int temp;

      while (left < right) {
        temp = mv.get(left);
        mv.set(left, mv.get(right));
        mv.set(right, temp);
        left += 1;
        right -= 1;
      }
    }
    return mv;
  }
}
