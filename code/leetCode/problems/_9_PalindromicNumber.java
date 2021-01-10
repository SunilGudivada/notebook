package leetCode.problems;

public class _9_PalindromicNumber {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int r, sum = 0, temp = x;

    while (x > 0) {
      r = x % 10;
      sum = (sum * 10) + r;
      x = x / 10;
    }
    return temp == sum;
  }

  public static void main(String[] args) {
    _9_PalindromicNumber obj = new _9_PalindromicNumber();
    System.out.println(obj.isPalindrome(121));
  }
}
