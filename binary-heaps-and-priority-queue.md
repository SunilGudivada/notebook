# Binary Heaps and Priority Queue

## Binary heap overview

First of all, what does a binary heap have to do with a binary tree? Why do people always draw binary trees as binary heap?

Because a binary heap is a special kind of binary tree \(complete binary tree\) that is stored in an array.In a general linked list binary tree, we manipulate Pointers to nodes, whereas in an array, we use an array index as a pointer

Binary heap is also divided into maximum heap and minimum heap.**The properties of the maximum heap are: each node is greater than or equal to its two children.** Similarly, the properties of the minimum heap are：each node is less than or equal to its children.

Both heap cores have the same idea, and this article takes maximum heap as an example.

For a maximum heap, by its nature, it is obvious that the top of the heap, arr\[1\], must be the largest element of all.

In array represenatation of the binary tree,  At any element k

* **Parent**: `k / 2`
* **Children** : `2 * k` and `2 * k + 1` 

```java
// the index of the parent node
int parent(int k) {
    return k / 2;
}
// index of left child
int left(int k) {
    return k * 2;
}
// index of right child
int right(int k) {
    return k * 2 + 1;
}
```

## Priority queue overview

A useful feature of priority queues is that when you insert or delete elements, the elements are sorted automatically, and the underlying principle is binary heap operations.

The function of data structure is nothing more than adding and deleting，Priority queues have two main API, to insert an element and to remove the largest element（If the bottom uses the minimum heap，it will be `delMin`）.

Let's implement a simplified priority queue, starting with the code framework：

PS：For clarity, Java generics are used here，`Key` can be any data type of comparable value，You can think of it as int, char, etc

```java
public class MaxPQ
    <Key extends Comparable<Key>> {
    // An array of storage elements
    private Key[] pq;
    // Number of elements in the current Priority Queue
    private int N = 0;

    public MaxPQ(int cap) {
        // Index 0 is not used, so allocate one more space
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* Returns the largest element in the current queue */
    public Key max() {
        return pq[1];
    }

    /* Insert element e */
    public void insert(Key e) {...}

    /* Removes and returns the largest element in the current queue */
    public Key delMax() {...}

    /* swim the KTH element to maintain the maximum heap properties */
    private void swim(int k) {...}

    /* Sink the KTH element to maintain maximum heap properties */
    private void sink(int k) {...}

    /* Swap the two elements of the array */
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* Is pq[i] less than pq[j]？ */
    private boolean compare(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /* and left, right, parent methods */
}
```

## Swim and Sink Implementation

For a maximum heap, there are two cases where the nature of the heap is destroyed:

1. If some node A is smaller than its children, then A doesn't deserve to be the parent node, so it should go down, and the larger node down here comes up as the parent node, and that's **sink** on A
2. If some node A is bigger than its parent, then A should not be the child node, but the parent node should be replaced and the parent node should be the parent node itself, which is the **swim** of A

```java
// If you float to the top of the heap, you can't float any higher
public void swim(int k){
    while( k > 1 && compare(a[k/2], a[k])){
        // If the KTH element is larger than the top
        // replace k
        swap(a[k], a[k/2]);
        k = k/2;
    } 
}

public void sink(int k){
   // Sink to the bottom and stop
    while (left(k) <= N) {
        // Let's assume that the left node is larger
        int older = left(k);
        // If the right node exists, compare the value
        if (right(k) <= N && compare(older, right(k)))
            older = right(k);
        // Node k is bigger than both of the children, so you don't have to sink
        if (compare(older, k)) break;
        // Otherwise, it doesn't fit the maximum heap structure, sinking k nodes
        swap(k, older);
        k = older;
    }
}
```

**The** **`insert`** **method first adds the element to be inserted to the bottom of the heap and then floats it up to the correct position**

```java
public void insert(Comparable val){
   N++;
   // add the new element to the end
   pq[N] = e;
   // Let it swim to the right place
   swim(N);
}
```

**`delMax` first swap top element A with bottom element B, then delete A, and finally let B sink to the correct position**

```java
public Key delMax() {
    // the top of the largest heap is the largest element
    Key max = pq[1];
    //Change the maximum element to the end and delete it
    swap(1, N);
    pq[N] = null;
    N--;
    // Let the pq[i] sink to the correct position
    sink(1);
    return max;
}
```

## Sum up

A binary heap is a complete binary tree, so it is suitable for storing in an array, and the binary heap has some special properties.

Binary heap operation is very simple, mainly floating up and down, to maintain the nature of the heap \(heap order\), the core code is only 10 lines.

Priority queues are implemented based on binary heap, with the main operations being insert and delete. Insert is to insert to the end first and then float up to the correct position; Deletion is to reverse the position and then delete, and then sink to the correct position. The core code is only ten lines.

Perhaps this is the power of data structure, simple operation can achieve clever functions, really admire the invention of binary heap algorithm people!



## Reference

* [https://labuladong.gitbook.io/algo-en/ii.-data-structure/binary\_heap\_implements\_priority\_queues](https://labuladong.gitbook.io/algo-en/ii.-data-structure/binary_heap_implements_priority_queues)

