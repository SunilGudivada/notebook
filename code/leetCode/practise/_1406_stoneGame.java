package leetCode.practise;

import java.util.List;
import java.util.stream.Collectors;

public class _1406_stoneGame {


    public int helperRecursive(int[] arr, int i) {
        int[] dp = new int[50001];
        if (i >= arr.length) return 0;
        if (dp[i] != -1) {
            return dp[i];
        } else {
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans, arr[i] - helperRecursive(arr, i + 1));
            if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - helperRecursive(arr, i + 2));
            if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] + arr[i + 2] - helperRecursive(arr, i + 3));
            return dp[i] = ans;
        }
    }


    public int helperIterative(int[] arr) {
        int[] dp = new int[5001];
        int ans = -1;
        int n = arr.length;
        int i = n - 1;
        while (i >= 0) {
            ans = Integer.MIN_VALUE;
            ans = Math.max(ans, arr[i] - dp[i + 1]);
            if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - dp[i + 2]);
            if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] + arr[i + 2] - dp[i + 3]);
            dp[i] = ans;
            i--;
        }
        return ans;
    }

    public int helperSpaceOptimization(int[] arr) {
        int i_1 = 0, i_2 = 0, i_3 = 0;
        int ans = -1;
        int n = arr.length;
        int i = n - 1;
        while (i >= 0) {
            ans = Integer.MIN_VALUE;
            ans = Math.max(ans, arr[i] - i_1);
            if (i + 1 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] - i_2);
            if (i + 2 < arr.length) ans = Math.max(ans, arr[i] + arr[i + 1] + arr[i + 2] - i_3);
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
//        int alice = helperRecursive(stoneValue, 0);
//        int alice = helperIterative(stoneValue);
        int alice = helperSpaceOptimization(stoneValue);
        return displayResult(alice);
    }
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int currentSize = array.size();
        array = array.stream().filter(x -> !x.equals(toMove)).collect(Collectors.toList());
        int size = array.size();
        for(int i=0;i<=currentSize-size;i++){
            array.add(toMove);
        }
        return array;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6};
        System.out.println(new _1406_stoneGame().stoneGameIII(arr));
    }
}
