// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        boolean isPositive = true;
        
        if(x < 0) isPositive = false;
        x = Math.abs(x);
        int res = Integer.parseInt(new StringBuffer(""+x).reverse().toString());
        return isPositive ? res : -res;
    }
}