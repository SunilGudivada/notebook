package geeksForGeeks.recursion;

/**
 * Power Using Recursion You are given two numbers n and p. You need to find np.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 9 p = 9 Output: 387420489 Explanation: 387420489 is the value obtained when 9 is
 * raised to the power of 9.
 *
 * <p>Example 2:
 *
 * <p>Input: n = 2 p = 9 Output: 512 Explanation: 512 is the value obtained when 2 is raised to the
 * power of 9. Your Task: You don't need to read input or print anything. You only need to complete
 * the function RecursivePower() that takes n and p as parameters and returns np.
 *
 * <p>Expected Time Complexity: O(p). Expected Auxiliary Space: O(p).
 *
 * <p>Constraints: 1 <= n <= 9 0 <= p <= 9
 */
public class RecursivePower {
  static int get(int n, int p){
    if(p==0) return 1;
    return n*get(n, p-1);
  }
  public static void main(String[] args) {
    System.out.println(get(2,9));
  }
}
