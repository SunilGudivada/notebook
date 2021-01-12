# Merge Sort

## Java Implementation

```java
/*
==========================================================
Generic Implementation of Merge sort
Input: Used Comparable interface as input

Input: [ 3, 0, 5, 2, 1, 0, 0, 0, 4 ]
Output: [ 0, 0, 0, 0, 1, 2, 3, 4, 5 ]

Input: [ "three", "0", "five", "2", "one", "seven", "4" ]
Output: [ "0", "2", "4", "five", "one", "seven", "three" ]

==========================================================
*/

public static class mergeSort {
    public void merge(Comparable[] a, int low, int mid, int high) {
      int n1 = mid - low + 1;
      int n2 = high - mid;

      Comparable[] arr1 = new Comparable[n1];
      Comparable[] arr2 = new Comparable[n2];

      for (int i = 0; i < n1; i++) {
        arr1[i] = a[low + i];
      }

      for (int i = 0; i < n2; i++) {
        arr2[i] = a[mid + i + 1];
      }

      int i = 0, j = 0, k = low;
      while (i < n1 && j < n2) {
        if (compare(arr1[i], arr2[j])) {
          a[k] = arr1[i];
          i++;
        } else {
          a[k] = arr2[j];
          j++;
        }
        k++;
      }

      while (i < n1) {
        a[k] = arr1[i];
        i++;
        k++;
      }
      while (j < n2) {
        a[k] = arr2[j];
        j++;
        k++;
      }
    }

    public void sort(Comparable[] a, int low, int high) {
      if (low < high) {
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
      }
    }

    private boolean compare(Comparable comparable, Comparable comparable1) {
      return comparable.compareTo(comparable1) < 0;
    }
  }
```

