# Quick'3 Sort

```java
public class Quick2Sort {
    void sort(Comparable[] a, int low, int high) {
      if (high <= low) return;
      int lt = low, gt = high;
      Comparable v = a[low];
      int i = low;
      while (i <= gt) {
        int cmp = a[i].compareTo(v);
        if (cmp < 0) swap(a, lt++, i++);
        else if (cmp > 0) swap(a, i, gt--);
        else i++;
      }
      sort(a, low, lt - 1);
      sort(a, gt + 1, high);
    }

    private void swap(Comparable[] a, int i, int j) {
      Comparable swap = a[i];
      a[i] = a[j];
      a[j] = swap;
    }
}
```

