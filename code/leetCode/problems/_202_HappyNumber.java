package leetCode.problems;

public class _202_HappyNumber {
  public boolean isHappy(int n) {
    if (n == 1 || n == 7) {
      return true;
    } else if (n <= 9) {
      return false;
    }
    int sum = 0;
    while (n >= 9) {
      sum = sum + (int) Math.pow(n % 10, 2);
      n = n / 10;
    }
    sum = sum + (int) Math.pow(n, 2);
    return isHappy(sum);
  }

  public static void main(String[] args) {
    _202_HappyNumber obj = new _202_HappyNumber();
    System.out.println(obj.isHappy(4));
  }
}
