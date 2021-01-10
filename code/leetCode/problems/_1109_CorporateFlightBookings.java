package leetCode.problems;

import java.util.Arrays;

public class _1109_CorporateFlightBookings {
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] res = new int[n];
    for (int[] booking : bookings) {
      for (int j = booking[0]; j <= booking[1]; j++) {
        res[j-1] += booking[2];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _1109_CorporateFlightBookings obj = new _1109_CorporateFlightBookings();
    int[][] bookings = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
    System.out.println(Arrays.toString(obj.corpFlightBookings(bookings, 5)));
  }
}
