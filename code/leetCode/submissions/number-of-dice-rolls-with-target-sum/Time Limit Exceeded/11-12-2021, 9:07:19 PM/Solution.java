// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        final int MOD = 1000000007;
        if (d > target || target > d * f) return 0;
        if (d == 1) return (target <= f) ? 1 : 0;
        HashMap<String,Integer> map = new HashMap<>();
        String key = ""+d+f+target;
        if(!map.containsKey(key)) {
            int sum = 0;
            for (int i = 1; i <=f; i++) {
                sum += numRollsToTarget(d - 1, f, target - i);
                sum %= MOD;
            }
            map.put(key, sum);
        }

        return map.get(key);
    }
}