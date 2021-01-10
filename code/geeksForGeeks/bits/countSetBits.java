package geeksForGeeks.bits;

// Function to count set bits in the given number x
// n: input to count the number of set bits

public class countSetBits {
  public static void main(String[] args){
    int n = 5;
    int count = 0;
    while(n >0){
      n = n& n-1;
      count++;
    }
    System.out.println(count);
  }
}
