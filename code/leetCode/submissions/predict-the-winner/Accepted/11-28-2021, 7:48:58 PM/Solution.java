// https://leetcode.com/problems/predict-the-winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null) { return true; }
        int n = nums.length;
        if ((n & 1) == 0) { return true; }
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;

    }
}