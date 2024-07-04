# Quick Sort

* Inplace sorting algorithm
* For items <= 10 , use insertion sort instead of quick sort

## Java Implementation

```java
/*
==========================================================
Generic Implementation of Quick sort
Input: Used Comparable interface as input

Input: [ 3, 0, 5, 2, 1, 0, 0, 0, 4 ]
Output: [ 0, 0, 0, 0, 1, 2, 3, 4, 5 ]

Input: [ "three", "0", "five", "2", "one", "seven", "4" ]
Output: [ "0", "2", "4", "five", "one", "seven", "three" ]

==========================================================
*/

public static class quickSort {
  public int partition(Comparable[] a, int low, int high) {
    int i = low, j = high + 1;
      while (true) {
        while (compare(a[++i], a[low])) if (i == high) break;
        while (compare(a[low], a[--j])) if (j == low) break;
        if (i >= j) break;
        swap(a, i, j);
      }
      swap(a, low, j);
      return j;
  }

  void sort(Comparable[] a, int low, int high) {
    if (low < high) {
      int pi = partition(a, low, high);
      sort(a, low, pi - 1);
      sort(a, pi + 1, high);
    }
  }

  private boolean compare(Comparable comparable, Comparable comparable1) {
    return comparable.compareTo(comparable1) < 0;
  }
}

```

{% hint style="success" %}
### Properties

* Not stable
* $$O ( log( n))$$extra space
* $$O(n^{2})$$ time, but typically $$O( n * log(n))$$ time
* Not adaptive
{% endhint %}
