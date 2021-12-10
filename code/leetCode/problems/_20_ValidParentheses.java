package leetCode.problems;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));

            if (current.equals("[") || current.equals("{") || current.equals("(")) {
                stack.push(current);
            } else {
                if(!stack.isEmpty()) {
                    String top = stack.pop();
                    if (current.equals("}")) {
                        if (!top.equals("{")) return false;
                    } else if (current.equals("]")) {
                        if (!top.equals("[")) return false;
                    } else if (current.equals(")")) {
                        if (!top.equals("(")) return false;
                    }
                }else{
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
