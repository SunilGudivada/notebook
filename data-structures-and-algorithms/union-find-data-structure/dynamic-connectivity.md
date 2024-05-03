# Dynamic Connectivity

## Dynamic Connectivity

Given a set of N objects.

* **Union command:** connect two objects.
* **Find/connected query:** is there a path connecting the two objects?

![](<../../.gitbook/assets/image (9) (1).png>)

### Modelling the Connections

We assume "is connected to" is an equivalence relation:

* **Reflexive**: p is connected to p.
* **Symmetric**: if p is connected to q, then q is connected to p.
* **Transitive**: if p is connected to q and q is connected to r, then p is connected to

**Connected components:** Maximal set of objects that are mutually connected.

![](<../../.gitbook/assets/image (16) (1).png>)

### **Implementing Operations**

**Find Query:** Check if two objects are in the same component.

**Union command**: Replace components containing two objects with their union.

![](<../../.gitbook/assets/image (13) (1).png>)

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

##
