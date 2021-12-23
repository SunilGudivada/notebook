// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] array) {
       int n = array.length;
		
		int[] jumps = new int[array.length];
		jumps[0] = 0;
		
		for(int i=1;i<n;i++){
			jumps[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(array[j]+j >= i){
					jumps[i] = Math.min(jumps[i], 1+jumps[j]);
				}
			}
		}
		
		return jumps[n-1];
    }
}