# Quick Sort

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
    Comparable pivot = a[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (compare(a[j], pivot)) {
        i++;

        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }

    Comparable temp = a[i + 1];
    a[i + 1] = a[high];
    a[high] = temp;

    return i + 1;
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
## Properties

* Not stable
* $$O ( log( n))$$extra space
* $$O(n^{2})$$ time, but typically $$O( n * log(n))$$ time
* Not adaptive
{% endhint %}

