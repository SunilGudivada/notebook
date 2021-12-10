package leetCode.problems;

/**
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class _416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum+= nums[i];
        }

        return sum % 2 ==1 ? false : isSubsetSum(nums, sum /2, n);
    }

    public boolean isSubsetSum(int[] nums, int sum, int n){
        boolean[][] subset = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j< sum+1; j++){
                if(i == 0 ) subset[i][j] = false;
                if(j == 0) subset[i][j] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j< sum+1; j++){
                if(nums[i-1] <= j){
                    subset[i][j] = subset[i-1][j-nums[i-1]] || subset[i-1][j];
                }else{
                    subset[i][j] = subset[i-1][j];
                }
            }
        }
        return subset[n][sum];
    }
}
