package com.platform.leetCode.problems;

public class compareVersionNUmber {
  public static int compareVersions(String version1, String version2){

    String [] str1 = version1.split("\\.");
    String [] str2 = version2.split("\\.");

    int i=0, j=0;

    for(i=0,j=0; i<str1.length && j<str2.length; i++,j++){
      int a = Integer.parseInt(str1[i]);
      int b = Integer.parseInt(str2[j]);

      if(a == b) continue;

      return a>b ? 1 : -1;
    }

    while(i<str1.length){
      if(Integer.parseInt(str1[i]) > 0) return 1;

      i++;
    }

    while(j<str2.length){
      if(Integer.parseInt(str2[j]) > 0) return -1;

      j++;
    }

    return 0;
  }
  public static void main(String[] args){
    System.out.println(compareVersions("1.5","1.1.8"));
  }
}
