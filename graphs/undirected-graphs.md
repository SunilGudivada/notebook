# Undirected Graphs

Graph having two directions from any vertex in a path to another verted.

![Representation of undirected Graph](../.gitbook/assets/image%20%2899%29.png)

## **Adjacency Matrix Representations**

**Algorithm**

Maintain a two dimensional $$v * v$$ matrix boolean array

for each edge $$v - w$$ in graph: $$adj[v][w] = adj[w][v] = true$$ 

![Adjacency Matrix representation](../.gitbook/assets/image%20%2893%29.png)

**Note:** Adjacency matrix consumes more space.

{% hint style="success" %}
* **Space Complexity :** $$v^{2}$$ 
* **Add Edge:** 1
* Edge between $$v $$ and $$w$$ is 1
* Iterate over vertices adjacent to $$v$$ :  $$V$$ 
{% endhint %}

## Adjacency List Representation

In this representation , If there is path exists between any two vertices, vertices are added to vertex list.

![](../.gitbook/assets/image%20%2895%29.png)

### Java Implementation

```java
public class Graph {
  private final int V;
  private List<Integer>[] adj;

  public Graph(int v) {
    this.V = v;
    adj = new List[v];
    for (int i = 0; i < V; i++) {
      adj[i] = new ArrayList<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
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
* Edge between $$v $$ and $$w$$ is $$degree(v)$$ 
* Iterate over vertices adjacent to $$v$$ -  $$degree(v)$$ 
{% endhint %}

## Depth First Search

### Algorithm

To visit a vertex $$v$$  :

* Mark vertex $$v$$ as visited.
* Recursively visit all unmarked vertices adjacent to $$v$$.

![](../.gitbook/assets/image%20%2896%29.png)

### Java Implementation

```java
public class DepthFirstPaths
{
   // marked[v] = true if v connected to s
   private boolean[] marked;
   
   // edgeTo[v] = previous vertex on path from s to v
   private int[] edgeTo;
   private int s;
   
   public DepthFirstPaths(Graph G, int s)
   {
      // Initialize all the constructors
      ..............
      
      dfs(G, s); 
   }
      
   private void dfs(Graph G, int v)
   {
      marked[v] = true;
      for (int w : G.adj(v)){
         if (!marked[w])
         {
            dfs(G, w);
            edgeTo[w] = v;
         }
      }
   } 
   
   public boolean hasPathTo(int v)
   {  
      return marked[v];  
   }
   
   public Iterable<Integer> pathTo(int v)
   {
      if (!hasPathTo(v)) return null;
      Stack<Integer> path = new Stack<Integer>();
      for (int x = v; x != s; x = edgeTo[x])
         path.push(x);
      path.push(s);
      return path;
   }

}
```

## Bredth First Search

### Algorithm

Repeat until queue is empty

* Remove vertex $$v$$ from queue.
* Add to queue all unmarked vertices adjacent to $$v$$ and mark them.

![](../.gitbook/assets/image%20%2897%29.png)

### Java Implementation

```java
public class BreadthFirstPaths
{
   private boolean[] marked;
   private int[] edgeTo;
   
   private void bfs(Graph G, int s)
   {
       Queue<Integer> q = new Queue<Integer>();
       q.enqueue(s);
       marked[s] = true;
       while (!q.isEmpty())
       {
          int v = q.dequeue();
          for (int w : G.adj(v))
          {
             if (!marked[w])
             {
                q.enqueue(w);
                marked[w] = true;
                edgeTo[w] = v;
             } 
          }
       }
   }
 }
```

## Connected Components

A **connected component** is a maximal set of connected vertices.

![Connected Components](../.gitbook/assets/image%20%2898%29.png)

### Algorithm

To visit a vertex v :

* Mark vertex v as visited.
* Recursively visit all unmarked vertices adjacent to v.

![](../.gitbook/assets/image%20%28100%29.png)

### Java Implementation

```java
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    
    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        
        for(int i=0;i<G.V();i++){
            if(!marked[i])
            {
                dfs(G, i);
                 count++;
            }
        }
    }
    
    public int count()
    {  
        return count;  
    }
    
    public int id(int v)
    {  
        return id[v];  
    }
    
    // all vertices discovered in same call of dfs have same id
    private void dfs(Graph G, int v)
    {
       marked[v] = true;
       idp[v] = count;
       for (int w : G.adj(v))
          if (!marked[w])
              dfs(G, w);
     }
    
    

}
```

