package geeksForGeeks.bits;

/**
 * Number is sparse or not Given a number N. The task is to check whether it is sparse or not. A
 * number is said to be a sparse number if no two or more consecutive bits are set in the binary
 * representation.
 *
 * <p>Example 1:
 *
 * <p>Input: N = 2 Output: true Explanation: Binary Representation of 2 is 10, which is not having
 * consecutive set bits. So, it is sparse number. Example 2:
 *
 * <p>Input: N = 3 Output: false Explanation: Binary Representation of 3 is 11, which is having
 * consecutive set bits in it. So, it is not a sparse number.
 *
 * <p>Your Task: The task is to complete the function checkSparse() that takes n as a parameter and
 * returns true if the number is sparse else returns false.
 *
 * <p>Expected Time Complexity: O(log N). Expected Auxiliary Space: O(1).
 *
 * <p>Constraints: 1 <= N <= 106
 */
public class isSparse {
  static boolean checkIfSparse(int n){
    boolean isValid = true;
    while(n>0){
      if(((n & (n>>1) ) & 1) ==1){
        isValid = false;
        break;
      }
      n = n>>1;
    }
    return isValid;
  }

  public static void main(String[] args){
    System.out.println(checkIfSparse(22));
  }
}