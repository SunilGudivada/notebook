// https://leetcode.com/problems/minimum-absolute-difference

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        int minimumDifference = Integer.MAX_VALUE;
        
        for(int i=0;i< arr.length-1;i++){
            int currentDifference = Math.abs(arr[i+1] - arr[i]);
            List<List<Integer>> currentList = map.getOrDefault(currentDifference, new ArrayList<>());
            
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i+1]);
            
            currentList.add(list);
            map.put(currentDifference, currentList);
            
            minimumDifference = Math.min(minimumDifference, currentDifference);
        }
        
        return map.getOrDefault(minimumDifference, new ArrayList<>());
    }
}