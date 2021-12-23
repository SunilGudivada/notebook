// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];
        
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        
        
        for(int i=0;i<list.size();i++){
            int[] zeroDimension = list.get(i);
            if(!row[zeroDimension[0]] || !col[zeroDimension[1]]){
                matrix = fill(matrix, zeroDimension[0], zeroDimension[1]);
                row[zeroDimension[0]] = true;
                col[zeroDimension[1]] = true;
            }
        }        
    }
    
    public static int[][] fill(int[][] matrix, int m, int n){
        
        for(int i=0;i<matrix.length;i++){
            matrix[i][n] = 0;
        }
        
        for(int i=0;i<matrix[0].length;i++){
            matrix[m][i] = 0;
        }
        
        return matrix;
    }
}