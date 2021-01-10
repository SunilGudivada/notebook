package geeksForGeeks.arrays;

/**
 * Rotate Array Easy Accuracy: 50.28% Submissions: 22396 Points: 2 Given an unsorted array arr[] of
 * size N, rotate it by D elements in the counter-clockwise direction.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 5, D = 2 arr[] = {1,2,3,4,5} Output: 3 4 5 1 2 Explanation: 1 2 3 4 5 when rotated
 * by 2 elements, it becomes 3 4 5 1 2. Example 2:
 *
 * <p>Input: N = 10, D = 3 arr[] = {2,4,6,8,10,12,14,16,18,20} Output: 8 10 12 14 16 18 20 2 4 6
 * Explanation: 2 4 6 8 10 12 14 16 18 20 when rotated by 3 elements, it becomes 8 10 12 14 16 18 20
 * 2 4 6.
 *
 * <p>Your Task: Complete the function rotateArr() which takes the array, D and N as input
 * parameters and rotates the array by D elements.
 *
 * <p>Expected Time Complexity: O(N) Expected Auxiliary Space: O(1)
 *
 * <p>Constraints: 1 <= N <= 10^7 1 <= D <= N 0 <= arr[i] <= 10^5
 */
public class rotateArray {
  static void rotateArr(int arr[], int d, int n) {
    int i = 0, j = n - 1, temp = 0;
    while (i < j) {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
    i = 0;
    j = n - d - 1;
    while (i < j) {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
    i = n - d;
    j = n - 1;
    while (i < j) {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}
