# Shell Sort

## Java Implementation

```java
/*
==========================================================
Generic Implementation of Shell sort
Input: Used Comparable interface as input

Input: [ 3, 0, 5, 2, 1, 0, 0, 0, 4 ]
Output: [ 0, 0, 0, 0, 1, 2, 3, 4, 5 ]

Input: [ "three", "0", "five", "2", "one", "seven", "4" ]
Output: [ "0", "2", "4", "five", "one", "seven", "three" ]

==========================================================
*/
public static class Shell {

  public void sort(Comparable[] a) {
    int h = 0;
    while (h < a.length / 3) h = 3 * h + 1;
    while (h >= 1) {
      for (int i = h; i < a.length; i++) {
        for (int j = i; j >= h && compare(a[j], a[j - h]); j -= h) {
          swap(a, j, j - h);
        }
      }
      h = h / 3;
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

* Not stable
* $$O ( 1)$$ extra space
* $$O(n^{3/2})$$time as shown \(see below\)
* **Adaptive**: $$O(n*log(n))$$time when nearly sorted
* Fast unless array size is huge
{% endhint %}

