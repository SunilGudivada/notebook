package leetCode.problems;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 10^5
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums.length == 0 ) return new ArrayList<>();
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0 ;i< nums.length -2;i++){
            if(i==0 || ( nums[i] != nums[i-1] )){
                int low = i+1;
                int high = nums.length -1;
                int sum = -nums[i];

                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > sum){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }

        return res;
    }
}
