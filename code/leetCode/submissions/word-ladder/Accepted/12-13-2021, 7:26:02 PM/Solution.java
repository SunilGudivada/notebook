// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) return 0;
        int result = 1;
        int size = 0;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        
        Set<String> set = new HashSet<>(wordList);
        q.add(beginWord);
        q.add(null);
        String modifiedWord = "";
        
        while(!q.isEmpty()){
            
            String currentWord = q.remove();
            if(currentWord!=null){
                while(size < beginWord.length()){
                    char[] charArr = currentWord.toCharArray();
                    for(char i='a';i<= 'z';i++){
                        
                        if(i != currentWord.charAt(size)){
                            charArr[size] = i;
                            modifiedWord = new String(charArr);

                            if(modifiedWord.equals(endWord)){
                                return result+1;
                            }

                            if(set.contains(modifiedWord) && !visited.contains(modifiedWord)){
                               q.add(modifiedWord);
                                visited.add(modifiedWord);
                            }
                        }
                        
                    }
                    size++;
                }
            }else{
                result++;
                if (!q.isEmpty()) { 
                    q.add(null);
                  }
            }
            size = 0;
        }
        System.gc();        
        return 0;
    }
}