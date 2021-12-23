// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> output= new ArrayList<>();
        int[] current_interval = intervals[0];
        output.add(current_interval);
        for(int[] interval : intervals){
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            
            int next_begin = interval[0];
            int next_end = interval[1];
            
            if(current_end >= next_begin){
                current_interval[1] = Math.max(current_end, next_end);
            }else{
                current_interval = interval;
                output.add(current_interval);
            }
        }
        
        return output.toArray(new int[output.size()-1][]);
    }
}