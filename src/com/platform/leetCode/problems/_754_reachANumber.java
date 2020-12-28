package com.platform.leetCode.problems;

public class _754_reachANumber {
  public int reachNumber(int target) {
    target = Math.abs(target);
    int sum = 0, step = 0;
    while (sum < target || (sum - target) % 2 != 0) {
      step++;
      sum += step;
    }
    return step;
  }

  public static void main(String[] args) {
    _754_reachANumber obj = new _754_reachANumber();
    System.out.println(obj.reachNumber(3));
  }
}
