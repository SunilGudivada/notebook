// https://leetcode.com/problems/number-of-islands

class Solution {
    
    public void markIsland(char[][] grid, int i, int j, int m, int n) {
       if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;

        grid[i][j] = '2';

        markIsland(grid, i - 1, j, m, n);
        markIsland(grid, i, j - 1, m, n);
        markIsland(grid, i + 1, j, m, n);
        markIsland(grid, i, j + 1, m, n);
    }

    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j, m, n);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;

    }
}