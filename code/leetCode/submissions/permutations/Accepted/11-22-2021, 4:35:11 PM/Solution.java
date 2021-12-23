// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<>(), nums);
        return output;
    }
    
    public void backtrack(List<List<Integer>> output, ArrayList<Integer> current, int[] nums){
        if(current.size() == nums.length){
            output.add(new ArrayList<>(current));
        }else{
            for(int i = 0; i < nums.length; i++){ 
             if(current.contains(nums[i])) continue; // element already exists, skip
             current.add(nums[i]);
             backtrack(output, current, nums);
             current.remove(current.size() - 1);
          }
        }
    }
}