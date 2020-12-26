package com.platform.leetCode.problems;

import java.util.Arrays;

public class _498_diagonalTraverse {
  public int[] findDiagonalOrder(int[][] matrix) {
    int m= matrix.length;
    if(m==0){
      return new int[]{};
    }
    int n = matrix[0].length;
    if(n ==0 ){
      return new int[]{};
    }
    int[] ans = new int[m*n];
    int row =0;
    int col=0;
    for(int i=0;i<m*n;i++){
      ans[i] = matrix[row][col];
      if((row+col)%2==0){
        if(col == n-1){
          row++;
        } else if(row ==0){
          col++;
        } else{
          row--;
          col++;
        }
      } else{
        if(row ==m-1){
          col++;
        } else if(col==0){
          row++;
        } else{
          row++;
          col--;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    _498_diagonalTraverse obj = new _498_diagonalTraverse();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(Arrays.toString(obj.findDiagonalOrder(matrix)));
  }
}
