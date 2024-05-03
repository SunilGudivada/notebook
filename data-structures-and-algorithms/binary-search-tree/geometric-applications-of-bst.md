# Geometric Applications of BST

## 1-D Range Search

This is the extension for symbol table.

* Insert key-value pair.
* Search for key `k`.
* Delete key `k`.
* **Range search:** Find all keys between `k1 & k2`.
* **Range count:** Number of keys between `k1 & k2`.

![](<../../.gitbook/assets/image (88) (1).png>)

**Implementation**

* **Un Ordered List**: Fast Insertion and slow search
* **Ordered List**: Slow insert, binary search for k1 and k2 to do range search.

### BST Implementation

**Example1:**

![](<../../.gitbook/assets/image (89).png>)

**Java code to find the number of keys between** `low` **and** `high`

```java
// Running time is proportional to log(n)
public int size(key low, key high) {
    if(contains(high)){
        return rank(high) - rank(low) + 1;
    } else {
        return rank(high) - rank(low);
    }
}
```

**Example 2:**

![](<../../.gitbook/assets/image (90) (1).png>)

## Line Segment Intersection

Given N horizontal and vertical line segments, find all intersections.

![](<../../.gitbook/assets/image (83).png>)

### Sweep-line algorithm

Sweep vertical line between left to right and record your observations

**Algorithm:**

* x-coordinates define events.
* **h-segment (left endpoint):** insert y-coordinate into BST.
* **h-segment (left endpoint):** insert y-coordinate into BST.
* **v-segment:** Range search for interval of y-end points.

**Explanation:**

* Put x-coordinate in PQ (or Sort ) . -------------> `N * log(N)`
* Insert y-coordinate into the BST . -------------> `N * log(N)`
* Remove y-coordinate from the BST -------------> `N * log(N)`
* Range Searches in BST -------------> `N * log(N) + R`

## 1D Interval Search Trees

Data structure to hold the set of overlapping intervals.

Create BST, where each node stores an interval `(lo, hi)`.

* Use left endpoint as BST key.
* Store max endpoint in subtree rooted at node.

![](<../../.gitbook/assets/image (92) (1).png>)

### Algorithm

* If interval in node intersects query interval, return it.
* Else if left subtree is null, go right.
* Else if max endpoint in left subtree is less than lo, go right.
* Else go left.

![](<../../.gitbook/assets/image (86) (1).png>)

### Java Implementation

```java
..............

 TreeNode x = root;
 
 while(x!=null){
     if(x.interval.insersects(lo,hi)){
         return x.interval;
     }else if(x.left == null) {
         x = x.right;
     }else if(x.left.max < lo){
         x = x.right;
     }else {
         x = x.left;
     }
 }

return null;

..............
```

### Interval Search Tree Analysis

**Implementation:** Use a red-black BST ( easy to maintain auxiliary information using log N extra work per op ) to guarantee performance.

![order of growth of running time for N intervals](<../../.gitbook/assets/image (85) (1).png>)

## Orthogonal rectangle intersection

**Goal**: Find all intersections among a set of N orthogonal rectangles.

![](<../../.gitbook/assets/image (87) (1).png>)

Here we use the same principle sweep line algorithm. Sweep one vertical line from left to right. when you encounter left end point insert y interval. and repeat the interval search until you get the right end point.

### Algorithm

* x-coordinates of left and right endpoints define events.
* Maintain set of rectangles that intersect the sweep line in an interval search tree (using y-intervals of rectangle).
* **Left endpoint:** Interval search for y-interval of rectangle; insert y-interval.
* **Right endpoint:** Remove y-interval.

![Orthogonal Rectangle Intersection](<../../.gitbook/assets/image (84) (1).png>)

**Analysis**

* Put x-coordinate in PQ (or Sort ) . -------------> `N * log(N)`
* Insert y-coordinate into the BST . -------------> `N * log(N)`
* Reomve y-coordinate from the BST -------------> `N * log(N)`
* Interval Search for y Coordinates -------------> `N * log(N) + R * log(N)`

## Summary

![](<../../.gitbook/assets/image (91) (1).png>)
