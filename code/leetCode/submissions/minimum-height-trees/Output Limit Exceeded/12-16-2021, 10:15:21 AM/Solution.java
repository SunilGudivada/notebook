// https://leetcode.com/problems/minimum-height-trees

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        
        
        for(int i=0;i<edges.length;i++){
            
            List<Integer> connectingNodes = map.getOrDefault(edges[i][0], new ArrayList<>());
            connectingNodes.add(edges[i][1]);
            map.put(edges[i][0], connectingNodes);
            
            connectingNodes = map.getOrDefault(edges[i][1], new ArrayList<>());
            connectingNodes.add(edges[i][0]);
            map.put(edges[i][1], connectingNodes);
        }
        
        System.out.println(map);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){list.add(0);}
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            
            q.offer(i);
            int count=0;
            while(!q.isEmpty()){
                System.out.println("Queue:: "+Arrays.toString(q.toArray()));
                int qSize = q.size();
                for(int j=1;j<=qSize;j++){
                    int currentNode = q.poll();
                    if(j==1){ 
                        count++;
                    }
                    visited[currentNode] = true;
                    
                    if(map.containsKey(currentNode)){
                        List<Integer> adj = map.get(currentNode);
                        
                        for(int k=0;k < adj.size();k++){
                            // System.out.println(" Adjacent::: "+ adj.get(k)+ " -"+ visited[adj.get(k)]);
                            if(visited[adj.get(k)] == false){
                                q.offer(adj.get(k));
                            }
                        }
                    }
                }
                // System.out.println("End Queue:: "+Arrays.toString(q.toArray()));
            }
            min = Math.min(min, count);
            list.set(i, count);
            System.out.println(Arrays.toString(list.toArray()));
        }
        
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<list.size();i++){
            if(list.get(i) == min){
                result.add(i);
            }
        }
        
        return result;
        
        
    }
}