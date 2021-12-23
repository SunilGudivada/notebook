// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero

class Solution {
    public int numberOfSteps(int num) {
        int c =0;
        while(num !=0){
            if((num&1) !=0){
                num >>= 1;
            }else{
                num-=1;
            }
            c++;
        }
        return c;
    }
}