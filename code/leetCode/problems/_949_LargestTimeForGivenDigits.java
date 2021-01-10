package leetCode.problems;

import java.util.Scanner;

/**
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit
 * exactly once.
 *
 * <p>24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00
 * and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
 *
 * <p>Return the latest 24-hour time in "HH:MM" format. If no valid time can be made, return an
 * empty string.
 *
 * <p>Example 1:
 *
 * Input: A = [1,2,3,4]
 * Output: "23:41"
 * Explanation: The valid 24-hour times are "12:34",
 * "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these
 * times, "23:41" is the latest.
 *
 * Example 2:
 *
 * Input: A = [5,5,5,5]
 * Output: ""
 * Explanation: There are no valid 24-hour times as "55:55" is
 * not valid.
 *
 *
 * Example 3:
 *
 * <p>Input: A = [0,0,0,0] Output: "00:00"
 *
 *
 * Example 4:
 *
 * <p>Input: A = [0,0,1,0] Output: "10:00"
 *
 * Constraints:
 * arr.length == 4
 * 0 <= arr[i] <= 9
 */
public class _949_LargestTimeForGivenDigits {

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
