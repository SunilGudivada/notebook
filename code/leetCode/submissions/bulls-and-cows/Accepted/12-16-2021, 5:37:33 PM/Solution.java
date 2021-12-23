// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String s, String guess) {
        int n = s.length();
        int b = 0;
        int c = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == guess.charAt(i)){
                b++;
            }else{
                int count = map.getOrDefault(s.charAt(i),0);
                count++;
                map.put(s.charAt(i) , count);
            }
        }
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) != guess.charAt(i)){
                if(map.containsKey(guess.charAt(i))){
                    int count = map.get(guess.charAt(i));
                    if(count > 0){
                        count--;
                        c++;
                        if(count == 0 ){
                            map.remove(guess.charAt(i));
                        }else{
                            map.put(guess.charAt(i) , count);
                        }
                    }
                }
            }
            
        }
        return b+"A"+c+"B";
    }
}