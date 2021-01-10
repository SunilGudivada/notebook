package geeksForGeeks.arrays;

/**
 * Minimum adjacent difference in a circular array Easy Accuracy: 67.13% Submissions: 7234 Points: 2
 * Given an array Arr of N integers arranged in a circular fashion. Your task is to find the minimum
 * absolute difference between adjacent elements.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 7 Arr[] = {8,-8,9,-9,10,-11,12} Output: 4 Explanation: The absolute difference
 * between adjacent elements in the given array are as such: 16 17 18 19 21 23 4 (first and last).
 * Among the calculated absolute difference the minimum is 4. Example 2:
 *
 * <p>Input: N = 8 Arr[] = {10,-3,-4,7,6,5,-4,-1} Output: 1 Explanation: The absolute difference
 * between adjacent elements in the given array are as such: 13 1 11 1 1 9 3 11 (first and last).
 * Among the calculated absolute difference, the minimum is 1. Your Task: The task is to complete
 * the function minAdjDiff() which returns the minimum difference between adjacent elements in
 * circular array.
 *
 * <p>Expected Time Complexity: O(N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraint: 2 <= N <= 10^6 -10^6 <= Arr[i] <= 10^6
 */
public class minimumAdjacentDifferenceCircularArray {
  static int minAdjDiff(int arr[], int n) {
    int diff = Integer.MAX_VALUE;
    for(int i=0;i<n-1;i++){
      if(diff > Math.abs(arr[i]-arr[i+1])){
        diff = Math.abs(arr[i]-arr[i+1]);
      }
    }
    if(diff > Math.abs(arr[n-1]-arr[0])){
      diff = Math.abs(arr[n-1]-arr[0]);
    }
    return diff;
  }

  public static void main(String[] args) {
    int[] arr = {8,-8,9,-9,10,-11,12};
    System.out.println(minAdjDiff(arr, arr.length));
  }
}
