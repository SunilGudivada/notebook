# Quick Find - Eager Approach

## Quick Find - Eager Approach

**Data structure :** Integer Array `id[]`of length N

**Interpretation:**

**Find:** `p` and `q` are connected iff they have the same id.

**Union:** To merge components containing `p` and `q`, change all entries whose id equals `id[p]` to `id[q]`

![Quick Find  - Eager Approach](<../../.gitbook/assets/image (2) (1).png>)

After `union(6,1)`

![](<../../.gitbook/assets/image (6) (1).png>)

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
