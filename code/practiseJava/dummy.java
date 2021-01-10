package practiseJava;

import java.util.Arrays;

public class dummy

{
  public static void re(int [] a){
    int k=0;
    for(int i:a){
      if(i!=0){
        a[k++]=i;
      }
    }
    for(int i=k;i<a.length;i++){
      a[i]=0;
    }
  }
  public static void main(String[] args)
  {
    int[] nums = {3,0,5,2,1,0,0,0,4};
    re(nums);
    System.out.println(Arrays.toString(nums));

  }
}