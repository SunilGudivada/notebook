package leetCode.problems;

/**
 * Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is
 * constructed by these n numbers successfully if one of the following is true for the ith position
 * (1 <= i <= n) in this array:
 *
 * The number at the ith position is divisible by i. i is divisible by the number at the ith
 * position. Given an integer n, return the number of the beautiful arrangements that you can
 * construct.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: The first beautiful arrangement is [1, 2]:
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 *
 * The second beautiful arrangement is [2, 1]:
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1. Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= n <= 15
 */
public class _526_BeautifulArrangement {
  public int countArrangement(int n) {
    boolean[] visited = new boolean[n+1];
    return calc(1,n,visited);
  }

  // greedy method
  public int calc(int i,int n,boolean[] visited){
    if(i==n+1){
      return 1;
    }
    int res = 0;
    for(int num=1;num<=n;num++){
      if(!visited[num] && ((num%i==0) || (i%num==0))){
        visited[num] = true;
        res += calc(i+1,n,visited);
        visited[num] = false;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _526_BeautifulArrangement obj = new _526_BeautifulArrangement();
    System.out.println(obj.countArrangement(5));
  }
}
