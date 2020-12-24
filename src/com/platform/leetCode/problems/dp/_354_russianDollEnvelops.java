package com.platform.leetCode.problems.dp;

import java.util.Arrays;
import java.util.Comparator;

public class _354_russianDollEnvelops {

  public int maxEnvelopes(int[][] envelopes) {

    Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
    int lis[] = new int[envelopes.length];
    int n = lis.length;
    lis[0] = 1;
    int res= 0;
    for(int i=1;i<n;i++){
      lis[i] = 1;
      for(int j=0;j<i;j++){
        if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
          lis[i] = Math.max(lis[i],1+lis[j]);
        }
      }
      if(lis[i] > res){
        res = lis[i];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _354_russianDollEnvelops obj = new _354_russianDollEnvelops();
    int arr[][] = {{4,5},{4,6},{6,7},{2,3},{1,1}};
    System.out.println(obj.maxEnvelopes(arr));
  }
}
