# Insertion Sort

## Java Implementation

```java
/*
==========================================================
Generic Implementation of Insertion sort
Input: Used Comparable interface as input

Input: [ 3, 0, 5, 2, 1, 0, 0, 0, 4 ]
Output: [ 0, 0, 0, 0, 1, 2, 3, 4, 5 ]

Input: [ "three", "0", "five", "2", "one", "seven", "4" ]
Output: [ "0", "2", "4", "five", "one", "seven", "three" ]

==========================================================
*/

public static class Insertion {
    public void sort(Comparable[] a) {
      int N = a.length;
      for (int i = 0; i < N; i++)
        for (int j = i; j > 0; j--)
          if (compare(a[j], a[j-1]))
            swap(a, j, j-1);
          else break;
      }
    }

    private void swap(Comparable[] a, int i, int j) {
      Comparable swap = a[i];
      a[i] = a[j];
      a[j] = swap;
    }

    private boolean compare(Comparable comparable, Comparable comparable1) {
      return comparable.compareTo(comparable1) < 0;
    }
  }
```

{% hint style="success" %}
## Properties

* Stable
* $$O(1)$$ extra space
* $$O(n^{2})$$ comparisons and swaps
* **Adaptive**: $$O(n)$$ time when nearly sorted
* Very low overhead
{% endhint %}

