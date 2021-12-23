// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    public List<Integer> countSmaller(int[] arr) {
        LinkedList<Integer> result =new LinkedList<>();
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            int count =0;
            for(int j=i;j<n;j++){
                if(arr[j] < arr[i]){
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
}