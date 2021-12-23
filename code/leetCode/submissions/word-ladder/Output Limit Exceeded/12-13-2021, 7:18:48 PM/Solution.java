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
        StringBuilder modifiedWord = new StringBuilder(beginWord);
        
        while(!q.isEmpty()){
            
            String currentWord = q.remove();
            if(currentWord!=null){
                while(size < beginWord.length()){
                    for(char i='a';i<= 'z';i++){
                        
                        if(i != currentWord.charAt(size)){

                            modifiedWord = new StringBuilder(currentWord);
                            modifiedWord.setCharAt(size, i);

                            if(modifiedWord.toString().equals(endWord)){
                                return result+1;
                            }

                            if(set.contains(modifiedWord.toString()) && !visited.contains(modifiedWord.toString())){
                               q.add(modifiedWord.toString());
                                visited.add(modifiedWord.toString());
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
            System.out.println(Arrays.toString(q.toArray()));
        }
                
        return 0;
    }
}