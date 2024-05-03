# Heap Sort

## Java Implementation

```java
public static class Heap {
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int k = N / 2; k >= 1; k--) sink(a, k, N);
    while (N > 1) {
      swap(a, 1, N);
      sink(a, 1, --N);
    }
  }

  private static void sink(Comparable[] a, int k, int N) {
    while (left(k) <= N) {
      int older = left(k);
      if (right(k) <= N && compare(older, right(k)))
        older = right(k);
      if (compare(a, older, k)) break;
      swap(a, k, older);
      k = older;
    }
  }

  private static boolean compare(Comparable[] a, int i, int j) {
    return a[i].compareTo(a[j]) < 0;
  }
}
```

�
