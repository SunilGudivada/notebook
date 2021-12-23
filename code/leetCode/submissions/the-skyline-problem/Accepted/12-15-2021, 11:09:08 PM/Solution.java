// https://leetcode.com/problems/the-skyline-problem

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<int[]> height = new ArrayList<>();
        
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                List<Integer> list = new ArrayList();
                list.add(h[0]);
                list.add(cur);
                
                result.add(list);
                prev = cur;
            }
        }
        
        return result;
    }
}