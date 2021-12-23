// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++){
            int[] colSum = new int[n];
            for(int j=i; j<m;j++){
                for(int c =0;c<n;c++){
                    colSum[c] += matrix[j][c];
                }
                max = Math.max( max, prefixSum(colSum, k));
            }
        }
        return max;
    }
    
    public int prefixSum(int[] arr, int k){
        int result = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int prefixSum = 0;
        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            
            Integer target = set.ceiling(prefixSum - k);
            
            if(target != null){
                result = Math.max(result, prefixSum - target);
            }
            set.add(prefixSum);
        }
        
        return result;
        
    }
}