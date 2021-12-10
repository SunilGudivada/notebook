package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
public class _17_LetterCombinationsofaPhoneNumber {
  List<String> res = new ArrayList<>();
  char[][] map =
      new char[][] {
        {},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
      };

  public List<String> letterCombinations(String digits) {

    if(digits.length() !=0)
      generate(digits, "");
    return res;
  }

  private void generate(String digits, String str) {
    if (str.length() == digits.length()) {
      res.add(str);
    } else {
      int currDigit = digits.charAt(str.length()) - 48;
      for (int i = 0; i < map[currDigit].length; i++) {

        generate(digits, str + map[currDigit][i]);
      }
    }
  }

  public static void main(String[] args) {
    _17_LetterCombinationsofaPhoneNumber obj = new _17_LetterCombinationsofaPhoneNumber();
    String str = "23";
    System.out.println(obj.letterCombinations(str));
  }
}
