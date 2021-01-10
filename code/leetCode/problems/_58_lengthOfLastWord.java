package leetCode.problems;

/**
 * Given a string s consists of some words separated by spaces, return the length of the last word
 * in the string. If the last word does not exist, return 0.
 *
 * <p>A word is a maximal substring consisting of non-space characters only.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "Hello World" Output: 5 Example 2:
 *
 * <p>Input: s = " " Output: 0
 *
 * <p>Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 */
class _58_lengthOfLastWord {

  //two liner
  public int lengthOfLastWord(String s) {
    String[] sa = s.split(" ");
    return sa.length >0 ? sa[sa.length-1].length() : 0;
  }

  //one Liner
  public int lengthofLastWordOneLiner(String s){
    return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
  }
}
