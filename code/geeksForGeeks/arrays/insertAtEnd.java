package geeksForGeeks.arrays;

/**
 * Array insert at end Basic Accuracy: 71.42% Submissions: 10035 Points: 1 Insertion is a basic but
 * frequently used operation. Arrays in most languages can not be dynamically shrinked or expanded.
 * Here, we will work with such arrays and try to insert an element at the end of the array.
 *
 * <p>You are given an array arr. The size of the array is given by sizeOfArray. You need to insert
 * an element at the end.
 *
 * <p>Example 1:
 *
 * <p>Input: sizeOfArray = 6 arr[] = {1, 2, 3, 4, 5} element = 90 Output: 1 2 3 4 5 90 Explanation:
 * After inserting 90 at the end, we have array elements as 1 2 3 4 5 90. Example 2:
 *
 * <p>Input: sizeOfArray = 4 arr[] = {1, 2, 3} element = 50 Output: 1 2 3 50 Explanation: After
 * inserting 50 at the end, we have array elements as 1 2 3 50. Your Task: You don't need to read
 * input or print anything. You only need to complete the function insertAtEnd() that takes arr,
 * sizeOfArray, element as input and modifies arr as per requirements. The driver code takes care of
 * the printing.
 *
 * <p>Expected Time Complexity: O(1). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 2 <= sizeOfArray <= 1000 0 <= element, arri <= 10^6
 */
public class insertAtEnd {
  static void insert(int arr[],int sizeOfArray,int element)
  {
    arr[sizeOfArray-1] = element;
  }
  public static void main(String[] args) {

  }
}
