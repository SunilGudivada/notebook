# Quick Find - Lazy Approach

## Quick Union - Lazy Approach

Integer array `id[]` of length `N`.

**Interpretation**: `id[i]` is parent of `i`.

Root of `i` is `id[id[id[...id[i]...]]]`.

![](<../.gitbook/assets/image (20) (1).png>)

After`union(3,5)`

![](<../.gitbook/assets/image (1) (1).png>)

![](<../.gitbook/assets/image (7) (1).png>)

### Java Implementation

```java
public class QuickUnionUF 
{
   private int[] id;
   
   // set id of each object to itself (N array accesses)
   public QuickUnionUF(int N)
   {
      id = new int[N];
      for (int i = 0; i < N; i++) id[i] = i;
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
   
   // change root of p to point to root of q (depth of p and q array accesses)
   public void union(int p, int q)
   {
      int i = root(p);
      int j = root(q);
      id[i] = j;
   }
}
```

##
