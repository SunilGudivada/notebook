// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mem = new int[m][n];
        int longestPath = 0;
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                int currentPath = getLongestPath(matrix, m, n, i,j, mem);
                longestPath = Math.max(longestPath, currentPath);
            }
        }
        return longestPath;
    }
    
    public int getLongestPath(int[][] matrix, int m , int n, int i , int j, int[][] mem){
        if(mem[i][j] > 0) return mem[i][j];
        int max = 0;
        
        for(int[] dir:dirs){
            int x = i+dir[0], y = j + dir[1];
            if(x>=0 && x < m && y>=0 && y<n && matrix[x][y] > matrix[i][j]){
                int path = getLongestPath(matrix, m, n , x, y, mem);
                max = Math.max(path, max);
            }
        }
        mem[i][j] = max+1;
        
        return max+1;
    }
}