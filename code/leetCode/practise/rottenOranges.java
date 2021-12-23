package leetCode.practise;

import java.util.ArrayDeque;
import java.util.Queue;

class rottenOranges
{
    public boolean isValid(int[][] grid,int i,int j, int m, int n){
        if(i<0 || i > m-1 || j< 0 || j>n-1 ) return false;
        if(grid[i][j] == 1) {
            grid[i][j] = 2;
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int time =0;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.addLast(new int[]{time, i,j});
                }
            }
        }

        int[] current = new int[3];

        while(q.size() != 0){
            current = q.poll();
            int x = current[1];
            int y = current[2];
            if(isValid(grid, x+1, y,m,n)) q.addLast(new int[]{current[0]+1, x+1,y});
            if(isValid(grid, x, y+1,m,n)) q.addLast(new int[]{current[0]+1, x,y+1});
            if(isValid(grid, x, y-1,m,n)) q.addLast(new int[]{current[0]+1, x,y-1});
            if(isValid(grid, x-1, y,m,n)) q.addLast(new int[]{current[0]+1, x-1,y});
        }

        return current[0] ==0  ? -1 : current[0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,2},{0,1,2},{2,1,1}};
        System.out.println(new rottenOranges().orangesRotting(grid));
    }
}