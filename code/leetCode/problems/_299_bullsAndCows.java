package leetCode.problems;

import java.util.HashMap;

/**
 * You are playing the Bulls and Cows game with your friend.
 *
 * <p>You write down a secret number and ask your friend to guess what the number is. When your
 * friend makes a guess, you provide a hint with the following info:
 *
 * <p>The number of "bulls", which are digits in the guess that are in the correct position. The
 * number of "cows", which are digits in the guess that are in your secret number but are located in
 * the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such
 * that they become bulls. Given the secret number secret and your friend's guess guess, return the
 * hint for your friend's guess.
 *
 * <p>The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of
 * cows. Note that both secret and guess may contain duplicate digits.
 *
 * <p>Example 1:
 *
 * <p>Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a
 * '|' and cows are underlined: "1807" | "7810" Example 2:
 *
 * <p>Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a
 * '|' and cows are underlined: "1123" "1123" | or | "0111" "0111" Note that only one of the two
 * unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1
 * to be a bull. Example 3:
 *
 * <p>Input: secret = "1", guess = "0" Output: "0A0B" Example 4:
 *
 * <p>Input: secret = "1", guess = "1" Output: "1A0B"
 *
 * <p>Constraints:
 *
 * <p>1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret and guess consist of digits only.
 */
public class _299_bullsAndCows {
  public static String get(String secret, String guess) {
    HashMap<Character, Integer> secretHash = new HashMap<Character, Integer>();
    int bullCount = 0;

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) != guess.charAt(i)) {
        if (secretHash.get(secret.charAt(i)) != null) {
          int count = secretHash.get(secret.charAt(i));
          count = count + 1;
          secretHash.put(secret.charAt(i), count);
        } else {
          secretHash.put(secret.charAt(i), 1);
        }
      } else {
        bullCount++;
      }
    }
    int cowCount = 0;
    for (int i = 0; i < guess.length(); i++) {
      int count = 0;
      if (secret.charAt(i) != guess.charAt(i)) {
        if (secretHash.get(guess.charAt(i)) != null) {
          count = secretHash.get(guess.charAt(i));
          if (count > 0) {
            cowCount++;
          }
          if (count == 0) {
            secretHash.remove(guess.charAt(i));
          } else {
            secretHash.put(guess.charAt(i), --count);
          }
        }
      }
      //      System.out.println(secretHash);
    }
    StringBuilder sb = new StringBuilder();
    sb.append(bullCount).append("A").append(cowCount).append("B");
    System.out.println(sb);
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(get("1807", "7810").equals("1A3B")); // 1A3B
    System.out.println(get("1123", "0111").equals("1A1B")); // 1A1B
    System.out.println(get("11", "10").equals("1A0B")); // 1A0B
    System.out.println(get("1122", "2211").equals("0A4B")); // 0A4B
  }
}
