package geeksForGeeks.bits;

/*  function to find position of rightmost different bit
*   m, n : Integers to find rightmost different bits
*   You can have a look in the locked code for information
*   regarding other functions including driver code
 */

public class posOfRightMostDiffBit {
  public static void main(String[] args){
    int m = 52, n = 4;
    int pos = 1, res = m^n;
    for(int i=0;i<32;i++){
      if((res & (1<<i)) == 0){
        pos++;
      }else{
        break;
      }
    }
    System.out.println( pos > 32 ? 0: pos );
  }
}
