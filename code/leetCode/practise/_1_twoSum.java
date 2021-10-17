package leetCode.practise;

import java.util.Arrays;
import java.util.HashMap;

public class _1_twoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        _1_twoSum obj = new _1_twoSum();
        System.out.println(Arrays.toString(obj.twoSum(new int[]{3, 3}, 6)));
    }
}
