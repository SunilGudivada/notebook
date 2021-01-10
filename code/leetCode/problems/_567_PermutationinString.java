package leetCode.problems;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of
 * s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Constraints:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class _567_PermutationinString {
  // sliding window method
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length() || s2.length() == 0) return false;
    int[] s1Arr = new int[26];
    int[] s2Arr = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1Arr[s1.charAt(i) - 'a']++;
      s2Arr[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (isPermutation(s1Arr, s2Arr)) {
        return true;
      }
      s2Arr[s2.charAt(i) - 'a']--;
      s2Arr[s2.charAt(i + s1.length()) - 'a']++;
    }
    return isPermutation(s1Arr, s2Arr);
  }

  private boolean isPermutation(int[] s1Arr, int[] s2Arr) {
    for (int i = 0; i < 26; i++) {
      if (s1Arr[i] != s2Arr[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    _567_PermutationinString obj = new _567_PermutationinString();
    System.out.println(obj.checkInclusion("ab", "eidboaooo"));
  }
}
