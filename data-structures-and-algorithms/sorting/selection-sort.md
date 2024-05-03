# Selection Sort

* Select the min `j` `( j > i )`, swap with `i`

## Java Implementation

```java
/*
==========================================================
Generic Implementation of selection sort
Input: Used Comparable interface as input

Input: [ 3, 0, 5, 2, 1, 0, 0, 0, 4 ]
Output: [ 0, 0, 0, 0, 1, 2, 3, 4, 5 ]

Input: [ "three", "0", "five", "2", "one", "seven", "4" ]
Output: [ "0", "2", "4", "five", "one", "seven", "three" ]

==========================================================
*/

public class Selection {
    public void sort(Comparable[] a) {
      int N = a.length;
      for (int i = 0; i < N; i++) {
        int min = i;
        for (int j = i + 1; j < N; j++){
           if (compare(a[j], a[min])){
              min = j;
            }
        }
        swap(a, i, min);
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
### **Properties**

* $$O ( 1 )$$ extra space
* $$\theta(n^{2})$$ comparisons
* $$\theta(n)$$ swaps
* Not stable
* Not adaptive
{% endhint %}

## Reference

* [https://www.toptal.com/developers/sorting-algorithms/selection-sort](https://www.toptal.com/developers/sorting-algorithms/selection-sort)
