package leetCode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the
 * second number.
 *
 * <p>Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of
 * pairs can be formed in this fashion.
 *
 * <p>Given a set of pairs, find the length longest chain which can be formed. You needn't use up
 * all the given pairs. You can select pairs in any order.
 *
 * <p>Example 1: Input: [[1,2], [2,3], [3,4]] Output: 2 Explanation: The longest chain is [1,2] ->
 * [3,4]
 * Note: The number of given pairs will be in the range [1, 1000].
 */
public class _646_MaximumLengthPairChain {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));
    System.out.println(
    Arrays.stream(pairs).distinct().count());
    int lis[] = new int[pairs.length];
    lis[0] = 1;
    int max = 0;
    for(int i=1;i<pairs.length;i++){
      lis[i] = 1;
      for(int j=0;j<i;j++){
        if(pairs[i][1] > pairs[j][1] && pairs[i][0] > pairs[j][1]){
          lis[i] = Math.max(lis[i],1+lis[j]);
        }
      }
      if(lis[i] > max){
        max = lis[i];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    _646_MaximumLengthPairChain obj = new _646_MaximumLengthPairChain();
    int[][] chainPairs = new int[][]{{1,2}, {2,3}, {3,4}};
    System.out.println(obj.findLongestChain(chainPairs));
  }
}
