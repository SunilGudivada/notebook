package com.platform.leetCode.problems;

import java.util.Arrays;

public class _937_ReorderDataInLogFiles {
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(
        logs,
        (a, b) -> {
          int identA = a.indexOf(" ") + 1;
          int identB = b.indexOf(" ") + 1;

          boolean isLetterA = Character.isLetter(a.charAt(identA));
          boolean isLetterB = Character.isLetter(b.charAt(identB));
          if (isLetterA && isLetterB) {
            int cmp = a.substring(identA).compareTo(b.substring(identB));
            if (cmp != 0) return cmp;
            return a.compareTo(b);
          } else if (isLetterA && !isLetterB) {
            return -1;
          } else if (!isLetterA && isLetterB) {
            return 1;
          } else return 0;
        });
    return logs;
  }

  public static void main(String[] args) {
    _937_ReorderDataInLogFiles obj = new _937_ReorderDataInLogFiles();
    String[] logs = {
      "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
    };
    System.out.println(Arrays.toString(obj.reorderLogFiles(logs)));
  }
}
