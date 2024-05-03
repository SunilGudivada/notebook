---
description: https://leetcode.com/problems/reorder-data-in-log-files/
---

# Reorder Log files

You have an array of `logs`. Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric _identifier_. Then, either:

* Each word after the identifier will consist only of lowercase letters, or;
* Each word after the identifier will consist only of digits.

We will call these two varieties of logs _letter-logs_ and _digit-logs_. It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log. The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties. The digit-logs should be put in their original order.

Return the final order of the logs.

**Example 1:**

```
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
```

**Constraints:**

1. `0 <= logs.length <= 100`
2. `3 <= logs[i].length <= 100`
3. `logs[i]` is guaranteed to have an identifier, and a word after the identifier.

## Java Implementation

```java
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
```
