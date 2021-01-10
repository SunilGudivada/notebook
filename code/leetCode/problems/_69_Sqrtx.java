package leetCode.problems;

public class _69_Sqrtx {
  public int mySqrt(int x) {
    int low = 0, high = x;

    while(low <= high){
      long mid = low+(high-low)/2;

      if(mid*mid == x){
        return (int)mid;
      } else if(mid*mid > x){
        high = (int)mid-1;
      } else {
        low = (int)mid+1;
      }
    }

    return high;
  }

  public static void main(String[] args) {
    _69_Sqrtx obj = new _69_Sqrtx();
    System.out.println(obj.mySqrt(36));
  }
}
