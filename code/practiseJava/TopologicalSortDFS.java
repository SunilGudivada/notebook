package practiseJava;

import java.util.*;

public class TopologicalSortDFS {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] a = new int[V];
        boolean[] vis = new boolean[V + 1];
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(s, adj, vis, i);
            }
        }
        int j = 0;
        while (!s.isEmpty()) {
            a[j] = s.pop();
            j++;
        }
        return a;
    }

    static void dfs(ArrayDeque<Integer> s, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i) {
        vis[i] = true;
        for (int u : adj.get(i)) {
            if (!vis[u]) dfs(s, adj, vis, u);
        }
        s.push(i);


    }
}

