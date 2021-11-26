package leetCode.practise;

import java.util.HashMap;

public class _1155_NumberOfDiceWithTargetSum {
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

    public static void main(String[] args) {
        int d = 1, f=3, target = 3;
        d=2; f=6;target=7;
        System.out.println(new _1155_NumberOfDiceWithTargetSum().numRollsToTarget(d,f,target));
    }
}
