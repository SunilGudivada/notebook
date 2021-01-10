package geeksForGeeks.recursion;

/**
 * Digital Root You are given a number n. You need to find the digital root of n. DigitalRoot of a
 * number is the recursive sum of its digits until we get a single digit number.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 1 Output: 1 Explanation: Digital root of 1 is 1 Example 2:
 *
 * <p>Input: n = 99999 Output: 9 Explanation: Sum of digits of 99999 is 45 which is not a single
 * digit number, hence sum of digit of 45 is 9 which is a single digit number. Your Task: You don't
 * need to read input or print anything. Your task is to complete the function digitalRoot that
 * takes n as parameter and returns the digital root of n.
 *
 * <p>Expected Time Complexity: O((Num of Digits)^2). Expected Auxiliary Space: O(Num of Digits).
 *
 * <p>Constraints: 1 <= n <= 10^7
 */
public class digitalRoot {
  static int sum(int n){
    if(n<10) return n;
    int digit = n%10 + sum(n/10);
    return sum(digit);
  }
  public static void main(String[] args) {
    System.out.println(sum(99999));
  }
}
