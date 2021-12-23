// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        
        res[0] = pq.peek();
        
        for(int i=1;i<n-k+1;i++){
            pq.remove(nums[i-1]);
            pq.add(nums[i+k-1]);
            res[i] = pq.peek();
        }
        
        return res;
    }
}