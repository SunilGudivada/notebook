package com.company.leetCode;

import java.util.Scanner;

public class LargestTimeForGivenDigits_949 {

  private static final Scanner sc = new Scanner(System.in);

  public static String largestTime(int[] arr){
    String res = "";
    for(int i=0;i<4;i++){
      for(int j=0;j<4;j++){
        for(int k=0;k<4;k++){
          if (i == j || j == k || i == k)
            continue;
          String HH = arr[i] + "" + arr[j];
          String MM = arr[k] + "" + arr[6-i-j-k];
          String TIME = HH + ":" + MM;
          if(HH.compareTo("24") < 0 && MM.compareTo("60") <0 && res.compareTo(HH + ":" + MM) < 0){
            res = TIME;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args){

    int[] timeArr = new int[4];

    for(int i: timeArr)
      timeArr[i] =sc.nextInt();
    System.out.println(largestTime(timeArr));
  }
}
