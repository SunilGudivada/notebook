// https://leetcode.com/problems/the-skyline-problem

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        pq.put(0, 1);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.put(-h[1], pq.getOrDefault(-h[1], 0) + 1);
            } else {  
                if (pq.get(h[1]) > 1) {
                    pq.put(h[1], pq.get(h[1]) - 1);
                } else {
                    pq.remove(h[1]);
                }
            }
            int cur = pq.lastKey();
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                
                list.add(h[0]);
                list.add(cur);
                res.add(list);
                prev = cur;
            }
        }
        return res;
    }
    }