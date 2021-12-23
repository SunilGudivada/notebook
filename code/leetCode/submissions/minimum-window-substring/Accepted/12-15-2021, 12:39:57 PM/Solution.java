// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        
        if(s== "" || t == "") return "";
        
        HashMap<Character, Integer> dictionary = new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            int count = dictionary.getOrDefault(t.charAt(i),0);
            dictionary.put(t.charAt(i), count +1);
        }
        
        int l = 0 , r = 0;
        
        int[] result = new int[]{-1,0,0};
        HashMap<Character, Integer> windowDictionary = new HashMap<>();
        int generatedLength = 0;
        
        while(r < s.length()){
            
            char currentChar = s.charAt(r);
            int count = windowDictionary.getOrDefault(currentChar,0);
            windowDictionary.put(currentChar,count+1);
            
            if(dictionary.containsKey(currentChar) && dictionary.get(currentChar).intValue() == windowDictionary.get(currentChar).intValue()){
                generatedLength++;
            }
            
            while(l<=r && dictionary.size() == generatedLength){
                currentChar = s.charAt(l);
                
                if(result[0] == -1 || r-l+1 < result[0]){
                    result[0] = r-l+1;
                    result[1] = l;
                    result[2] = r;
                }
                
                windowDictionary.put(currentChar, windowDictionary.get(currentChar) -1);
                
                if(dictionary.containsKey(currentChar) &&  windowDictionary.get(currentChar).intValue() < dictionary.get(currentChar).intValue()){
                    generatedLength --;
                }
                l++;
            }
            
            r++;
            
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2]+1);
    }
}