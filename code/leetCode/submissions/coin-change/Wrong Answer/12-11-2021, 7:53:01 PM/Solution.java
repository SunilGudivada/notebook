// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0) return 0;
        Arrays.sort(coins);
        int i= coins.length-1;
        int count =0;
        
        while(i>=0 && amount !=0){
            if(amount - coins[i] >= 0){
                amount = amount - coins[i];
                count++;
            }else{
                i--;
            }
        }
        return amount >0 ? -1: count;
    }
}