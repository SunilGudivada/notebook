// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];
        
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            if(frequency[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        
        return -1;
    }
}