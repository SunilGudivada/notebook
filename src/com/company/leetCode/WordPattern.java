package com.company.leetCode;

import java.util.HashMap;

public class WordPattern {
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
