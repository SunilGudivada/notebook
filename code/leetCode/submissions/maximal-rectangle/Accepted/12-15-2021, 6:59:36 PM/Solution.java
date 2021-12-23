// https://leetcode.com/problems/maximal-rectangle

class Solution {
            
    public int maximalRectangle(char[][] input) {
        int m = input.length;
        int n = input[0].length;

        int[][] matrix = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = Character.getNumericValue(input[i][j]);
            }
        }
        
        int maxArea = Integer.MIN_VALUE;
        int area = getMaxArea(matrix[0], n);        
        maxArea = Math.max(area, maxArea);
        
        int[] hist = matrix[0];
        
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    hist[j] = hist[j] + matrix[i][j];
                }else{
                    hist[j] = 0;
                }
            }
            area = getMaxArea(hist, n);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
        
    }
    
    
    public int getMaxArea(int hist[], int n) 
    {       
        int maxArea = Integer.MIN_VALUE;
        
        int[] right = new int[n];
        int[] left = new int[n];
        
        Stack<Integer> s = new Stack<>();
        
        // next smaller element to right
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && hist[s.peek()] >= hist[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = n;
            }else{
                right[i] = s.peek();
            }
            
            s.push(i);
        }
        
        s = new Stack<>();
        
        // next smaller element to left
        // calculate width 
        // calculate area
        // calculate max area
         for(int i=0;i<n;i++){
            while(!s.isEmpty() && hist[s.peek()] >= hist[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = s.peek();
            }
            int width = right[i] - left[i] -1;
            int area = width * hist[i];
            maxArea = Math.max(maxArea, area);
            s.push(i);
        }
        
        return maxArea;
    }
}