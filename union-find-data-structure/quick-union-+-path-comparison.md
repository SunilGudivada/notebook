# Quick Union + path comparison

## Quick Union + path comparison

![](../.gitbook/assets/image%20%2812%29.png)

![](../.gitbook/assets/image%20%2810%29.png)

![](../.gitbook/assets/image%20%2815%29.png)

![](../.gitbook/assets/image%20%2818%29.png)

### Java Implementation

```java
public class QuickUnionPathComparisonUF 
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
      while (i != id[i])
      { 
         id[i] = id[id[i]]; // only change with quick union
         i = id[i];
      }
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

