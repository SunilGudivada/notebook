package leetCode.problems;

import java.util.*;
/**
 *You have d dice and each die has f faces numbered 1, 2, ..., f. You are given three integers d, f, and target.
 *
 * Return the number of possible ways (out of fd total ways) modulo 109 + 7 to roll the dice so the sum of the face-up numbers equals target.
 *
 *
 *
 * Example 1:
 *
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * Example 2:
 *
 * Input: d = 2, f = 6, target = 7
 * Output: 6
 * Explanation:
 * You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 * 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 * Example 3:
 *
 * Input: d = 2, f = 5, target = 10
 * Output: 1
 * Explanation:
 * You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
 * Example 4:
 *
 * Input: d = 1, f = 2, target = 3
 * Output: 0
 * Explanation:
 * You throw one die with 2 faces.  There is no way to get a sum of 3.
 * Example 5:
 *
 * Input: d = 30, f = 30, target = 500
 * Output: 222616187
 * Explanation:
 * The answer must be returned modulo 10^9 + 7.
 *
 *
 * Constraints:
 *
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 */
public class _1155_NumberOfDiceRollsWithTargetSum {
    final int MOD = 1000000007;
    HashMap<String,Integer> map = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        if (d > target || target > d * f) return 0;
        if (d == 1) return (target <= f) ? 1 : 0;
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
