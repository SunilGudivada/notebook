// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        if (n==1) {
            res.add(0);
            return res;
        }
        
        int[] degree = new int[n];
        
        for(int i=0; i<n; i++) {
            myGraph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        
        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        for(int i=0; i<n; i++) 
            if (degree[i]==0) 
                return res;
            else if (degree[i]==1) {
                myQueue.offer(i);
            }

        while (!myQueue.isEmpty()) {
            res = new ArrayList<Integer>();
            int count = myQueue.size();

            for(int i=0; i<count; i++){
                int curr = myQueue.poll();
                res.add(curr);
                degree[curr]--;
                for(int k=0; k<myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    if (degree[next]==0) continue;
                    if (degree[next]==2) {
                        myQueue.offer(next);
                    }
                    degree[next]--;
                }
            }      	
        }
        return res;
    }
}