package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

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
