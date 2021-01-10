package leetCode.problems;

import java.util.*;

/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * <p>Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter
 * anywhere in word1 to make it equal to word2. For example, "abc" is a predecessor of "abac".
 *
 * <p>A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is
 * a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * <p>Return the longest possible length of a word chain with words chosen from the given list of
 * words.
 *
 * <p>Example 1:
 *
 * <p>Input: words = ["a","b","ba","bca","bda","bdca"] Output: 4 Explanation: One of the longest
 * word chain is "a","ba","bda","bdca". Example 2:
 *
 * <p>Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"] Output: 5
 *
 * <p>Constraints:
 *
 * <p>1 <= words.length <= 1000 1 <= words[i].length <= 16 words[i] only consists of English
 * lowercase letters.
 */
public class _1048_longestStringChain {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    HashMap<String, Integer> map = new HashMap<>();
    int res = 0;
    for (String word : words) {
      int tempRes = 1;
      StringBuilder string = new StringBuilder(word);
      int N = word.length();
      for (int j = 0; j < N; j++) {
        char ch = string.charAt(j);
        string.deleteCharAt(j);
        if (map.containsKey(string.toString()))
          tempRes = Math.max(tempRes, map.get(string.toString()) + 1);
        string.insert(j, ch);
      }
      map.put(word, tempRes);
      if (tempRes > res) {
        res = tempRes;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _1048_longestStringChain obj = new _1048_longestStringChain();
    String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    System.out.println(obj.longestStrChain(words));
  }
}
