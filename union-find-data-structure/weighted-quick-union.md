# Weighted Quick Union

## Weighted Quick Union

* Keep track of size of each tree (number of objects).
* Balance by linking root of smaller tree to root of larger tree.

![Comparison between Quick Union and Weighted Quick Union](<../.gitbook/assets/image (10).png>)

![](<../.gitbook/assets/image (11).png>)

**Data structure** Same as quick-union, but maintain extra array `sz[i]` to count number of objects in the tree rooted at `i`.

### Java Implementation

```java
public class WeightQuickUnionUF 
{
   private int[] id;
   private int[] sz;
   
   // set id of each object to itself (N array accesses)
   public QuickUnionUF(int N)
   {
      id = new int[N];
      sz = new int[N]; 
      for (int i = 0; i < N; i++) 
         id[i] = i;
         sz[i] = i;
   }
   
   // chase parent pointers until reach root (depth of i array accesses)
   private int root(int i)
   {
      while (i != id[i]) i = id[i];
      return i; 
   }
   
   // check if p and q have same root (depth of p and q array accesses)
   public boolean connected(int p, int q)
   {
      return root(p) == root(q);
   }
   
   /* 
   * change root of p to point to root of q 
   * (depth of p and q array accesses)
   * Link root of smaller tree to root of larger tree.
   */
   public void union(int p, int q)
   {
       int i = root(p);
       int j = root(q);
       if (i == j) return;
       if (sz[i] < sz[j]) 
       { 
          id[i] = j; 
          sz[j] += sz[i]; 
       }
       else 
       { 
          id[j] = i;
          sz[i] += sz[j]; 
       }
   }
}
```

### Analysis

* **Find**: takes time proportional to depth of `p` and `q`.
* **Union**: takes constant time, given roots.
* Depth of any node `x` is at most `log(N)`.
