// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pascal = new ArrayList<>();
        
        if(n >= 1) pascal.add(Arrays.asList(1));
        if(n >= 2) {
            pascal.add(Arrays.asList(1,1));
        }
        for(int i=2;i<n;i++){
            List<Integer> currentRow = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j ==0){
                    currentRow.add(1);
                }else if(j == i){
                    currentRow.add(1);
                }else{
                    int first = pascal.get(i-1).get(j-1);
                    int second = pascal.get(i-1).get(j);
                    currentRow.add( first + second);
                }
            }
            pascal.add(currentRow);
        }
        
        return pascal;
    }
}