package leetCode.problems;

import java.util.*;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class _46_Permutations{
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
