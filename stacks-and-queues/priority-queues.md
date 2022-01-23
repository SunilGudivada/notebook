# Priority Queues

Priority Queue is an extension of queue with following properties.

1. Every item has a priority associated with it.
2. An element with high priority is dequeued before an element with low priority.
3. If two elements have the same priority, they are served according to their order in the queue.

![](<../.gitbook/assets/image (24) (1).png>)

Few **important points on Priority Queue** are as follows:

* PriorityQueue doesn’t permit **null**.
* We can’t create PriorityQueue of Objects that are non-comparable
* PriorityQueue are unbound queues.
* The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements — ties are broken arbitrarily.
* Since PriorityQueue is not thread-safe, so java provides [PriorityBlockingQueue](https://www.geeksforgeeks.org/priorityblockingqueue-class-in-java/#:\~:text=PriorityBlockingQueue%20is%20an%20unbounded%20blocking,and%20supplies%20blocking%20retrieval%20operations.\&text=PriorityBlockingQueue%20class%20and%20its%20iterator,the%20Collection%20and%20Iterator%20interfaces.) class that implements the [BlockingQueue](https://www.geeksforgeeks.org/blockingqueue-interface-in-java/#:\~:text=Methods%20in%20Blocking%20Queue%20Interface\&text=Removes%20all%20available%20elements%20from,them%20to%20the%20given%20collection.\&text=Removes%20at%20most%20the%20given,them%20to%20the%20given%20collection.) interface to use in java multithreading environment.
* The queue retrieval operations poll, remove, peek, and element access the element at the head of the queue.
* It provides $$O(log(n))$$ time for add and poll methods.
* It inherits methods from **AbstractQueue**, **AbstractCollection**, **Collection** and **Object** class.

## Java implementation using comparators

```java
public class PriorityQueueUnordered<Key extends Comparable<Key>>{
     private Key[] pq;
     private int N;
     
     public PriorityQueueUnordered(int capacity)
     { 
          pq = (Key[]) new Comparable[capacity]; 
     }
     
     public boolean isEmpty()
     { 
          return N == 0; 
     }
     
     public void insert(Key x)
     { 
          pq[N++] = x; 
     }
     
     public Key delMax()
     {
          int max = 0;
          for (int i = 1; i < N; i++)
               if (less(max, i)) max = i;
          exch(max, N-1);
          return pq[--N];
     }
}
```
