package leetCode.problems;

/**
 * Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.
 *
 * Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2 or 3 stones from the first remaining stones in the row.
 *
 * The score of each player is the sum of values of the stones taken. The score of each player is 0 initially.
 *
 * The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.
 *
 * Assume Alice and Bob play optimally.
 *
 * Return "Alice" if Alice will win, "Bob" if Bob will win or "Tie" if they end the game with the same score.
 *
 *
 *
 * Example 1:
 *
 * Input: values = [1,2,3,7]
 * Output: "Bob"
 * Explanation: Alice will always lose. Her best move will be to take three piles and the score become 6. Now the score of Bob is 7 and Bob wins.
 * Example 2:
 *
 * Input: values = [1,2,3,-9]
 * Output: "Alice"
 * Explanation: Alice must choose all the three piles at the first move to win and leave Bob with negative score.
 * If Alice chooses one pile her score will be 1 and the next move Bob's score becomes 5. The next move Alice will take the pile with value = -9 and lose.
 * If Alice chooses two piles her score will be 3 and the next move Bob's score becomes 3. The next move Alice will take the pile with value = -9 and also lose.
 * Remember that both play optimally so here Alice will choose the scenario that makes her win.
 * Example 3:
 *
 * Input: values = [1,2,3,6]
 * Output: "Tie"
 * Explanation: Alice cannot win this game. She can end the game in a draw if she decided to choose all the first three piles, otherwise she will lose.
 * Example 4:
 *
 * Input: values = [1,2,3,-1,-2,-3,7]
 * Output: "Alice"
 * Example 5:
 *
 * Input: values = [-1,-2,-3]
 * Output: "Tie"
 *
 *
 * Constraints:
 *
 * 1 <= values.length <= 50000
 * -1000 <= values[i] <= 1000
 */
public class _1406_StoneGameIII {
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6};
        System.out.println(new _1406_StoneGameIII().stoneGameIII(arr));
    }
}
