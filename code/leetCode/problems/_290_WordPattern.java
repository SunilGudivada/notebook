package leetCode.problems;

import java.util.HashMap;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * <p>Here follow means a full match, such that there is a bijection between a letter in pattern and
 * a non-empty word in s.
 *
 * <p>Example 1:
 *
 * <p>Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 *
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 * Example 4:
 *
 * Input: pattern = "abba", s = "dog dog dog dog"
 * Output: false
 *
 * <p>Constraints:
 *
 * <p>1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lower-case English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */
public class _290_WordPattern {
  public static boolean wordPattern(String pattern, String str) {
    HashMap charToWordMapping = new HashMap();
    HashMap<String, Character> wordToCharMapping = new HashMap<>();
    String[] splitStr = str.split(" ");

    if (splitStr.length != pattern.length()) {
      return false;
    }

    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      String w = splitStr[i];
      if (!charToWordMapping.containsKey(c)) {
        if (wordToCharMapping.containsKey(w)) {
          return false;
        } else {
          charToWordMapping.put(c, w);
          wordToCharMapping.put(w, c);
        }

      } else {
        String mapped_word = (String) charToWordMapping.get(c);
        if (!mapped_word.equals(w))
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(wordPattern("stts", "cat dog dog cat"));
  }
}
