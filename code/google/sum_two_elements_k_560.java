package google;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * This problem was recently asked by Google.
 *
 * <p>Given a list of numbers and a number k, return whether any two numbers from the list add up to
 * k.
 *
 * <p>For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class sum_two_elements_k_560 {

  /**
   * Method 1 - fails if k is 20
   */
  static boolean method1(int[] arr, int k) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int finalI = i;
      if (IntStream.of(arr).anyMatch(x -> x == k - arr[finalI])) {
        count++;
      }
    }
    return (count != 0);
  }

  static boolean method2(int[] arr, int k) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (set.contains(k - arr[i])) return true;
      set.add(arr[i]);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {10, 15, 3, 7};
    int k = 17;
    System.out.println(method1(arr, k));
    System.out.println(method2(arr, k));
  }
}
