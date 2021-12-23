// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length() != s.length()) return false;
        return (goal+goal).contains(s);
    }
}