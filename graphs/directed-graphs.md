# Directed Graphs

**DiGraph**: Set of vertices connect pairwise by directed edges

## Adjacency List Representation

![](../.gitbook/assets/image%20%2895%29.png)

### Java Implementation

```java
public class diGraph {
  private final int V;
  private List<Integer>[] adj;

  public diGraph(int v) {
    this.V = v;
    adj = new List[v];
    for (int i = 0; i < V; i++) {
      adj[i] = new ArrayList<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public static void main(String[] args) {}
}
```

{% hint style="success" %}
* **Space Complexity :** $$E + V$$ 
* **Add Edge:** 1
* Edge between $$v $$ and $$w$$ is $$outdegree(v)$$ 
* Iterate over vertices adjacent to $$v$$ -  $$outdegree(v)$$ 
{% endhint %}

## **DI-Graph Applications**

![](../.gitbook/assets/image%20%2897%29.png)

\*\*\*\*

