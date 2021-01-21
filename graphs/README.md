# Graphs

**Graph:**  A graph is a data structure that consists of the following two components:  
**1.** A finite set of vertices also called as nodes.  
**2.** A finite set of ordered pair of the form \(u, v\) called as edge. The pair is ordered because \(u, v\) is not the same as \(v, u\) in case of a directed graph\(di-graph\). The pair of the form \(u, v\) indicates that there is an edge from vertex u to vertex v. The edges may contain weight/value/cost.

## **Terminology**

* **Path**: Sequence of vertices connected by edges.
* **Cycle**: Path whose first and last vertices are the same.
* **Degree**: Number of connected vertices for a node.
* **Euler Tour**: Cycle that uses each edge exactly once.
* **Hamilton tour:** Cycle that uses each vertex exactly once.
* **Biconnectivity:** Vertex whose removal disconnects the graph.



![](../.gitbook/assets/image%20%2894%29.png)

## **Graph API**

```java
public class Graph{

    // Initialize the graph with v vertices
    Graph(int v);
    
    // Add an edge between vertex v and vertex w
    void addEdge(int v , int w);
    
    // Vertices adjacent to v
    Iteratable<Integer> adj(int v);
    
    // Number of Vertices
    int V();
    
    // Number of Edges
    int E();

}
```

## **Graph Utility**

### **Degree**

 ****Number of vertices connected to $$v$$ 

```java
public static int degree(Graph G, int v){
    int degree = 0;
    for(int w : G.adj(v) ){
        degree++;
    } 
    return degree;
}
```

### **Max Degree** 

```java
public static int maxDegree(Graph G){
    int max = 0;
    for( int v=0; v < G.V(); v++ ){
        max = Math.max(degree(G, v), max);
    } 
    return max;
}
```

### **Average Degree**

```java
public static double averageDegree(Graph G){
    return 2.0 * G.E() / G.V();
}
```

### Self Loops

```java
public static int countSelfLoops(Graph G){
    int count = 0;
    for(int v=0;v<G.V(); v++){
        for(int w: G.adj(v)){
            if(v == w) {
                count++; 
            }
        }
    }
    return count/2; // Each edge counted twice
}
```

