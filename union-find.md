# Union Find

## Dynamic Connectivity

Given a set of N objects.

* **Union command:** connect two objects.
* **Find/connected query:** is there a path connecting the two objects?

![](.gitbook/assets/image%20%287%29.png)

### Modelling the Connections

We assume "is connected to" is an equivalence relation:

* **Reflexive**: p is connected to p.
* **Symmetric**: if p is connected to q, then q is connected to p.
* **Transitive**: if p is connected to q and q is connected to r, then p is connected to 

**Connected components:** Maximal set of objects that are mutually connected.

![](.gitbook/assets/image%20%289%29.png)

### **Implementing Operations**

**Find Query:** Check if two objects are in the same component.

**Union command**: Replace components containing two objects with their union.

![](.gitbook/assets/image%20%288%29.png)

### Union Find Data Type - Java

```java
public class UF {

    // initialize union-find data structure with N objects (0 to N – 1)
    UF(int N);
    
    // add connection between p and q
    void union(int p, int q);
    
    // are p and q in the same component?
    boolean connected(int p, int q);
    
    // component identifier for p (0 to N – 1)
    int find(int p);
    
    // number of components
    int count();
}
```

## Quick Find

### Eager Approach

**Data structure :** Integer Array `id[]`of length N 

**Interpretation:** 

**Find:** `p` and `q` are connected iff they have the same id.

**Union:** To merge components containing `p` and `q`, change all entries whose id equals `id[p]` to `id[q]`

![Quick Find  - Eager Approach](.gitbook/assets/image%20%281%29.png)

After `union(6,1)`

![](.gitbook/assets/image%20%284%29.png)

### Java Implementation

{% code title="QuickFindUF.java" %}
```java
public class QuickFindUF
{
   private int[] id;
   
   // set id of each object to itself (N array accesses)
   public QuickFindUF(int N)
   {
      id = new int[N];
      for (int i = 0; i < N; i++)
         id[i] = i;
   }
   
   // check whether p and q are in the same component (2 array accesses)
   public boolean connected(int p, int q)
   {  
      return id[p] == id[q];  
   }
   
   // change all entries with id[p] to id[q] (at most 2N + 2 array accesses)
   public void union(int p, int q)
   {
      int pid = id[p];
      int qid = id[q];
      for (int i = 0; i < id.length; i++)
         if (id[i] == pid) id[i] = qid;
   }
}

```
{% endcode %}

## Quick Union

### Lazy Approach

Integer array `id[]` of length `N`. 

**Interpretation**: `id[i]` is parent of `i`. 

Root of `i` is `id[id[id[...id[i]...]]]`.

![](.gitbook/assets/image%20%2811%29.png)

After`union(3,5)`

![](.gitbook/assets/image.png)

![](.gitbook/assets/image%20%285%29.png)

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

## Defects

### **Quick-find defect**

* Union too expensive \(N array accesses\). 
* Trees are flat, but too expensive to keep them flat.

### Quick-union defect

* Trees can get tall.
* Find too expensive \(could be N array accesses\).

## Improvements

## Weighted Quick Union

* Keep track of size of each tree \(number of objects\).
* Balance by linking root of smaller tree to root of larger tree.

![Comparison between Quick Union and Weighted Quick Union ](.gitbook/assets/image%20%282%29.png)

![](.gitbook/assets/image%20%286%29.png)

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

## Quick Union + path comparison

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

## WQUPC - Weighted quick-union with path compression: amortized analysis

Linear-time algorithm for M union-find ops on N objects? 

Cost within constant factor of reading in the data. In theory, WQUPC is not quite linear. In practice, WQUPC is linear.

![M union-find operations on a set of N objects](.gitbook/assets/image%20%2810%29.png)

