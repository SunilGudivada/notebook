// https://leetcode.com/problems/numbers-at-most-n-given-digit-set

class Solution {
    
    int count =0;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        Arrays.sort(digits);
        for(int i=0;i<digits.length;i++){
            atMostNGivenDigitSet(digits, n , Integer.parseInt(digits[i]));
        }
        return count;
    }
    
    public void atMostNGivenDigitSet(String[] digits, int n, int currentNumber) {
        if(currentNumber <= n){
            count++;
            for(int i=0;i<digits.length;i++){
                atMostNGivenDigitSet(digits, n , currentNumber*10 + Integer.parseInt(digits[i]));
            }
        }
    }
}