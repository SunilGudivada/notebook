package leetCode.practise;

import java.util.*;

public class _17_letterCombinationsOfPhoneNumber {
    List<String> res = new ArrayList<>();

    List<List<String>> dl = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) return res;
        dl.add(new ArrayList<>());
        dl.add(new ArrayList<>());
        dl.add(Arrays.asList("a", "b", "c"));
        dl.add(Arrays.asList("d", "e", "f"));
        dl.add(Arrays.asList("g", "h", "i"));
        dl.add(Arrays.asList("j", "k", "l"));
        dl.add(Arrays.asList("m", "n", "o"));
        dl.add(Arrays.asList("p", "q", "r", "s"));
        dl.add(Arrays.asList("t", "u", "v"));
        dl.add(Arrays.asList("w", "x", "y", "z"));


        helper(digits, 0, "");

        return res;
    }

    public void helper(String digits, int index, String current) {
        if (digits.length() == index) {
            res.add(current);
            return;
        }
        int currentNumber = Integer.parseInt(String.valueOf(digits.charAt(index)));
        List<String> currentList = dl.get(currentNumber);
        for (int i = 0; i < currentList.size(); i++) {
            helper(digits, index + 1, current + dl.get(currentNumber).get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new _17_letterCombinationsOfPhoneNumber().letterCombinations("23"));
    }
}
