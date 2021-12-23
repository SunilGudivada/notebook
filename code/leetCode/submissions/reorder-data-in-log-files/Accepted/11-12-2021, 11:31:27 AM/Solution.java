// https://leetcode.com/problems/reorder-data-in-log-files

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b) -> {
            int identA = a.indexOf(" ")+1;
            int identB = b.indexOf(" ")+1;
                    
            boolean isLetterA = Character.isLetter(a.charAt(identA));
            boolean isLetterB = Character.isLetter(b.charAt(identB));
            
            if(isLetterA && isLetterB){
                int cmp = a.substring(identA).compareTo(b.substring(identB));
                if (cmp != 0) return cmp;
                return a.compareTo(b);
            } else if(isLetterA && !isLetterB){
                return -1;
            } else if(!isLetterA && isLetterB){
                return 1;
            }else{
                 return 0;
            }
        });
            return logs;

    }
}