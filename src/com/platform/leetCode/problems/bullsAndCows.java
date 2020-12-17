package com.platform.leetCode.problems;

import java.util.HashMap;

public class bullsAndCows {
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
