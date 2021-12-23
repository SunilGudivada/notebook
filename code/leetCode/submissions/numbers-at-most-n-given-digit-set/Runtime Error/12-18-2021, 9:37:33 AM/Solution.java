// https://leetcode.com/problems/numbers-at-most-n-given-digit-set

class Solution {
    
    public int atMostNGivenDigitSet(String[] digits, int n) {
       
        int count = 0;
        
        String boundaryString = String.valueOf(n);
        
        for(int i=1;i<boundaryString.length();i++){
            count += Math.pow(digits.length, i);
        }
        
        int i=0;
        
        while(i< digits.length){
            int j=0;
            
            while(j<digits.length && Integer.parseInt(digits[j]) < Integer.parseInt(String.valueOf(boundaryString.charAt(i)))){
                count += Math.pow(digits.length, boundaryString.length()-i-1);
                j++;
            }
            
            if(j == digits.length || Integer.parseInt(digits[j]) >Integer.parseInt( String.valueOf(boundaryString.charAt(i)))){
                break;
            }
            i++;
        }
        
        if(i == boundaryString.length()){
            count++;
        }
        
        return count;
    }
    
}