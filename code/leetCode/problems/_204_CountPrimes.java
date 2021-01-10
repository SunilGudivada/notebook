package leetCode.problems;

import java.util.stream.IntStream;

/** Count the number of prime numbers less than a non-negative number, n. */
public class _204_CountPrimes {
  public int countPrimes(int n) {
    if (n <= 1) return 0;
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) count++;
    }
    return count;
  }

  private boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i = i + 6) {
      if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
  }

  private boolean isPrime2(int n) {
    return IntStream.rangeClosed(2, n / 2).noneMatch(i -> n % i == 0);
  }
}
