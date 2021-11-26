package leetCode.practise;

import java.util.*;

public class _20_validParentheses {
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

    public static void main(String[] args) {
        System.out.println(new _20_validParentheses().isValid("("));
    }
}
