# Geometric Applications of BST

## 1-D Range Search

This is the extension for symbol table. 

* Insert key-value pair.
* Search for key `k`.
* Delete key `k`.
* **Range search:** Find all keys between `k1 & k2`.
* **Range count:** Number of keys between `k1 & k2`.

![](../.gitbook/assets/image%20%2888%29.png)

**Implementation**

* **Un Ordered List**: Fast Insertion and slow search
* **Ordered List**: Slow insert, binary search for k1 and k2 to do range search.

### BST Implementation

**Example1:**

![](../.gitbook/assets/image%20%2889%29.png)

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

![](../.gitbook/assets/image%20%2890%29.png)

## Line Segment Intersection

Given N horizontal and vertical line segments, find all intersections.

![](../.gitbook/assets/image%20%2883%29.png)

### Sweep-line algorithm

Sweep vertical line between left to right and record your observations

**Algorithm:**

* x-coordinates define events.
* **h-segment \(left endpoint\):** insert y-coordinate into BST.
* **h-segment \(left endpoint\):** insert y-coordinate into BST.
* **v-segment:** Range search for interval of y-end points.

**Explanation:**

* Put x-coordinate in PQ \(or Sort \) .            -------------&gt;  `N * log(N)`
* Insert y-coordinate into the BST .             -------------&gt;  `N * log(N)`
* Remove y-coordinate from the BST         -------------&gt;  `N * log(N)`
* Range Searches in BST                              -------------&gt;  `N * log(N) + R`

## 1D Interval Search Trees

Data structure to hold the set of overlapping intervals.

Create BST, where each node stores an interval `(lo, hi)`.

* Use left endpoint as BST key.
* Store max endpoint in subtree rooted at node.

![](../.gitbook/assets/image%20%2892%29.png)

### Algorithm

* If interval in node intersects query interval, return it.
* Else if left subtree is null, go right. 
* Else if max endpoint in left subtree is less than lo, go right.
* Else go left.

![](../.gitbook/assets/image%20%2886%29.png)

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

**Implementation:** Use a red-black BST \( easy to maintain auxiliary information using log N extra work per op \) to guarantee performance. 

![order of growth of running time for N intervals](../.gitbook/assets/image%20%2885%29.png)

## Orthogonal rectangle intersection

**Goal**: Find all intersections among a set of N orthogonal rectangles.

![](../.gitbook/assets/image%20%2887%29.png)

Here we use the same principle sweep line algorithm. Sweep one vertical line from left to right.     when you encounter left end point insert y interval. and repeat the interval search until you get the right end point. 

### Algorithm

* x-coordinates of left and right endpoints define events. 
* Maintain set of rectangles that intersect the sweep line in an interval search tree \(using y-intervals of rectangle\).
* **Left endpoint:** Interval search for y-interval of rectangle; insert y-interval.
* **Right endpoint:** Remove y-interval.

![Orthogonal Rectangle Intersection](../.gitbook/assets/image%20%2884%29.png)

**Analysis**

* Put x-coordinate in PQ \(or Sort \) .            -------------&gt;  `N * log(N)`
* Insert y-coordinate into the BST .             -------------&gt;  `N * log(N)`
* Reomve y-coordinate from the BST         -------------&gt;  `N * log(N)`
* Interval Search for y Coordinates             -------------&gt;  `N * log(N) + R * log(N)`

## Summary

![](../.gitbook/assets/image%20%2891%29.png)

