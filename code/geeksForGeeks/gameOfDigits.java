package geeksForGeeks;

import java.util.Stack;

public class gameOfDigits {

  static long multiplyDigits(long n){
    if(n<10) return n;
    return (n%10)*multiplyDigits(n/10);
  }

  static String smallestK(long n)
  {
    for ( Integer i=0 ;i< Integer.MAX_VALUE;i++){
      if(n == multiplyDigits(i)){
        return i.toString();
      }
    }
    return "-1";
  }

  static long smallest(long n){
    if (n >= 0 && n <= 9) {
      return n;
    }
    Stack<Integer> digits = new Stack<>();

    for (int i = 9; i >= 2 && n > 1; i--) {
      while (n % i == 0) {
        digits.push(i);
        n = n / i;
      }
    }

    if (n != 1) {
      return -1;
    }

    long k = 0;
    while (!digits.empty()) {
      k = k * 10 + digits.peek();
      digits.pop();
    }

    return k;
  }

  public static void main(String[] args) {
    int num = 12;
    System.out.println(
    smallestK(num));
  }
}
