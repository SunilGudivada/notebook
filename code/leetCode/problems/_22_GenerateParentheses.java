package leetCode.problems;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    public void backtrack(List<String> output, String current, int open, int close, int max ){
        if(current.length() == 2 * max){
            output.add(current);
            return;
        }

        if(open < max) backtrack(output, current + "(", open +1, close, max);
        if(close < open) backtrack(output, current + ")", open, close +1, max);
    }
}
