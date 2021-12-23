// https://leetcode.com/problems/stone-game-iii

class Solution {
    public int helperSpaceOptimization(int[] arr) {
        int i_1 = 0, i_2 = 0, i_3 = 0;
        int ans = -1;
        int n = arr.length;
        int i = n - 1;
        while (i >= 0) {
            ans = Integer.MIN_VALUE;
            ans = Math.max(ans, arr[i] - i_1);
            if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - i_2);
            if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1]+arr[i+2] - i_3);
            i_3 = i_2;
            i_2 = i_1;
            i_1 = ans;
            i--;
        }
        return ans;
    }
    
    public String displayResult(int count) {
        if (count > 0) {
            return "Alice";
        } else if (count == 0) {
            return "Tie";
        } else {
            return "Bob";
        }

    }

    public String stoneGameIII(int[] stoneValue) {
        int alice = helperSpaceOptimization(stoneValue);
        return displayResult(alice);

    }
}