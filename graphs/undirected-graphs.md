# Undirected Graphs

## **Glossary**

* A _self-loop_ is an edge that connects a vertex to itself.
* Two edges are _parallel_ if they connect the same pair of vertices.
* When an edge connects two vertices, we say that the vertices are _adjacent to_ one another and that the edge is _incident on_ both vertices.
* The _degree_ of a vertex is the number of edges incident on it.
* A _subgraph_ is a subset of a graph's edges (and associated vertices) that constitutes a graph.
* A _path_ in a graph is a sequence of vertices connected by edges, with no repeated edges.
* A _simple path_ is a path with no repeated vertices.
* A _cycle_ is a path (with at least one edge) whose first and last vertices are the same.
* A _simple cycle_ is a cycle with no repeated vertices (other than the requisite repetition of the first and last vertices).
* The _length_ of a path or a cycle is its number of edges.
* We say that one vertex is _connected to_ another if there exists a path that contains both of them.
* A graph is _connected_ if there is a path from every vertex to every other vertex.
* A graph that is not connected consists of a set of _connected components_, which are maximal connected subgraphs.
* An _acyclic graph_ is a graph with no cycles.
* A _tree_ is an acyclic connected graph.
* A _forest_ is a disjoint set of trees.
* A _spanning tree_ of a connected graph is a subgraph that contains all of that graph's vertices and is a single tree. A _spanning forest_ of a graph is the union of the spanning trees of its connected components.
* A _bipartite graph_ is a graph whose vertices we can divide into two sets such that all edges connect a vertex in one set with a vertex in the other set.

Graph having two directions from any vertex in a path to another verted.

![Representation of undirected Graph](<../.gitbook/assets/image (95).png>)

## **Adjacency Matrix Representations**

**Algorithm**

Maintain a two dimensional $$v * v$$ matrix boolean array

for each edge $$v - w$$ in graph: $$adj[v][w] = adj[w][v] = true$$

![Adjacency Matrix representation](<../.gitbook/assets/image (96).png>)

**Note:** Adjacency matrix consumes more space.

{% hint style="success" %}
* **Space Complexity :** $$v^{2}$$
* **Add Edge:** 1
* Edge between $$v$$and $$w$$ is 1
* Iterate over vertices adjacent to $$v$$ : $$V$$
{% endhint %}

## Adjacency List Representation

In this representation , If there is path exists between any two vertices, vertices are added to vertex list.

![](<../.gitbook/assets/image (97).png>)

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
* Edge between $$v$$and $$w$$ is $$degree(v)$$
* Iterate over vertices adjacent to $$v$$ - $$degree(v)$$
{% endhint %}

## Depth First Search

### Algorithm

To visit a vertex $$v$$ :

* Mark vertex $$v$$ as visited.
* Recursively visit all unmarked vertices adjacent to $$v$$.

![](<../.gitbook/assets/image (98).png>)

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

![](<../.gitbook/assets/image (99).png>)

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

![Connected Components](<../.gitbook/assets/image (100).png>)

### Algorithm

To visit a vertex v :

* Mark vertex v as visited.
* Recursively visit all unmarked vertices adjacent to v.

![](<../.gitbook/assets/image (101).png>)

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
    
    // All vertices discovered in same call of dfs have same id
    private void dfs(Graph G, int v)
    {
       marked[v] = true;
       id[v] = count;
       for (int w : G.adj(v))
          if (!marked[w])
              dfs(G, w);
    }
}
```

## **Undirected Graph Applications**

![](<../.gitbook/assets/image (93).png>)
