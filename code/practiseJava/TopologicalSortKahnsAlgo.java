package practiseJava;

import java.util.*;

class TopologicalSortKahnsAlgo
{
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[V];
        int[] inDegree = getIndegree(V,  adj);
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count =0;
        while(!q.isEmpty()){
            int v = q.remove();
            result[count] = v;
            count++;
            ArrayList<Integer> currentNode = adj.get(v);
            for(int av: currentNode){
                inDegree[av]--;
                if(inDegree[av] == 0){
                    q.offer(av);
                }
            }
        }

        return result;

    }

    static int[] getIndegree(int V, ArrayList<ArrayList<Integer>> adj){
        int[] in = new int[V];
        for(int i=0;i<adj.size();i++){
            ArrayList<Integer> current = adj.get(i);
            for(int j=0;j<current.size();j++){
                in[current.get(j)]++;
            }
        }

        return in;
    }
}