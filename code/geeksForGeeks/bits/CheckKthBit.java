package geeksForGeeks.bits;

/*
* Given a number N and a bit number K, check if Kth bit of N is set or not.
* A bit is called set if it is 1. Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
* Example, Consider N = 4(100):  0th bit = 0, 1st bit = 0, 2nd bit = 1
 */
public class CheckKthBit {
  public static void main(String[] args) {
    int n = 4, k = 2;
    if((n>>k & 1) == 1){
      System.out.println(true);
    }else{
      System.out.println(false);
    }
  }
}
