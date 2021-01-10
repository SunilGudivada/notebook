package geeksForGeeks.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Max and Second Max Easy Accuracy: 49.94% Submissions: 19600 Points: 2 Given an array arr[] of
 * size N of positive integers which may have duplicates. The task is to find the maximum and second
 * maximum from the array, and both of them should be distinct, so If no second max exists, then the
 * second max will be -1.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 3 arr[] = {2,1,2} Output: 2 1 Explanation: From the given array elements, 2 is the
 * largest and 1 is the second largest. Example 2:
 *
 * <p>Input: N = 5 arr[] = {1,2,3,4,5} Output: 5 4 Explanation: From the given array elements, 5 is
 * the largest and 4 is the second largest. Your Task: The task is to complete the function
 * largestAndSecondLargest(), which should return maximum and second maximum element from the array
 * with first element as maximum element and second element as second maximum(if there is no second
 * maximum the second element should be -1)
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 1 <= N <= 10^6 1 <= arr[i] <= 10^6
 */
public class largestAndSecondLargest {
  public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
    ArrayList<Integer> res = new ArrayList<>();
    Arrays.sort(arr);
    res.add(arr[sizeOfArray - 1]);
    for (int i = sizeOfArray - 1; i >= 0; i--) {
      if (res.get(0) != arr[i]) {
        res.add(1, arr[i]);
        break;
      } else {
        res.add(1, -1);
      }
    }
    return res;
  }
}
