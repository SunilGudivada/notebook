package leetCode.problems;

import java.util.HashSet;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths, and
 * let a be the first half and b be the second half.
 *
 * <p>Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A',
 * 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * <p>Return true if a and b are alike. Otherwise, return false.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "book" Output: true Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1
 * vowel. Therefore, they are alike. Example 2:
 *
 * <p>Input: s = "textbook" Output: false Explanation: a = "text" and b = "book". a has 1 vowel
 * whereas b has 2. Therefore, they are not alike. Notice that the vowel o is counted twice. Example
 * 3:
 *
 * <p>Input: s = "MerryChristmas" Output: false Example 4:
 *
 * <p>Input: s = "AbCdEfGh" Output: true
 *
 * <p>Constraints:
 *
 * <p>2 <= s.length <= 1000 s.length is even. s consists of uppercase and lowercase letters.
 */
public class _1704_DetermineifStringHalvesAreAlike {
  public boolean halvesAreAlike(String s) {
    HashSet<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('A');
    vowels.add('E');
    vowels.add('I');
    vowels.add('O');
    vowels.add('U');
    int n =s.length();
    int i = 0;
    int j = n-1;
    int[] count = {0,0};
    while(i<j){
      if(vowels.contains(s.charAt(i))){
        count[0]++;
      }
      if(vowels.contains(s.charAt(j))){
        count[1]++;
      }
      i++;
      j--;
    }
    return count[0] == count[1];
  }

  public static void main(String[] args) {
    _1704_DetermineifStringHalvesAreAlike obj = new _1704_DetermineifStringHalvesAreAlike();
    System.out.println(obj.halvesAreAlike("AbCdEfGh"));
  }
}
