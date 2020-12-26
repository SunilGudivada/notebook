package com.platform.leetCode.problems.dp;

import java.util.Arrays;
import java.util.Comparator;

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
