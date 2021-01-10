package google;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 *
 * <p>For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30,
 * 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * <p>Follow-up: what if you can't use division?
 */
public class product_all_elements_except_that_element_562 {

  static void print(int[] arr) {

    for (int ele : arr) {
      System.out.print(ele + " ");
    }
    System.out.println();
  }

  /**
   * This method fails if any element in the array is having the zero
   *
   * @param arr
   * @return
   */
  static int[] method1(int[] arr) {
    int product = 1;
    for (int element : arr) {
      product *= element;
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = product / arr[i];
    }
    print(arr);
    return arr;
  }

  /**
   * Slight Modification to method1 Check number of occurences of 0, nonZeroProduct
   *
   * @param arr
   */
  static void method2(int[] arr) {
    int nonZeroProduct = 1;
    int countOfZeros = 0;

    for (int element : arr) {
      if (element != 0) {
        nonZeroProduct *= element;
      } else {
        countOfZeros++;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      if (countOfZeros > 1) {
        arr[i] = 0;
      } else if (countOfZeros == 1) {
        if (arr[i] == 0) {
          arr[i] = nonZeroProduct;
        } else {
          arr[i] = 0;
        }
      } else {
        arr[i] = nonZeroProduct / arr[i];
      }
    }
    print(arr);
  }

  /**
   * what if you can't use division?
   * Logarthimic wont work if element is negative or having zero,
   * hence including countOfZeros will work for us
   *
   * @param arr
   */
  static final double EPS = 1e-9;

  static void method3(int[] arr) {
    double sum = 0;
    int countOfZeros = 0;
    for (int j : arr) {
      if (j != 0) {
        sum += Math.log10(j);
      } else {
        countOfZeros++;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      if (countOfZeros > 1) {
        arr[i] = 0;
      } else if (countOfZeros == 1) {
        if (arr[i] == 0) {
          arr[i] = (int) (EPS + Math.pow(10.00, sum));
        } else {
          arr[i] = 0;
        }
      } else {
        arr[i] = (int) (EPS + Math.pow(10.00, sum - Math.log10(arr[i])));
      }
    }
    print(arr);
  }

  public static void main(String[] args) {
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {3, 2, 1};
    int arr3[] = {1, 2, 3, 4, 5, 0};
    int arr4[] = {1, 2, 3, 4, 5, 0, 0};

    //    System.out.println("::::::: Method 1 :::::::");
    //    method1(arr1);
    //    method1(arr2);
    //    method1(arr3); --- Fails in case of zero
    //    method1(arr4); --- Fails in case of zero

    //    System.out.println("::::::: Method 2 :::::::");
    //    method2(arr1);
    //    method2(arr2);
    //    method2(arr3);
    //    method2(arr4);

    System.out.println("::::::: Method 3 :::::::");
    method3(arr1);
    method3(arr2);
    method3(arr3);
    method3(arr4);
  }
}
