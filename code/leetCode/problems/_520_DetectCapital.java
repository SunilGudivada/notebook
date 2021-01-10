package leetCode.problems;

public class _520_DetectCapital {
  public boolean detectCapitalUse(String word) {
    int capitalLetters = 0;

    for (Character c : word.toCharArray()) {
      if (Character.isUpperCase(c)) capitalLetters++;
    }

    return capitalLetters == word.length()
        || capitalLetters == 0
        || (Character.isUpperCase(word.charAt(0)) && capitalLetters == 1);
  }

  // 0 ms faster
  public boolean detectCapitalUse2(String word) {
    if (word.length() == 1) {
      return true;
    }
    if (word.charAt(0) >= 'a') {
      for (int i = 1; i < word.length(); i++) {
        if (word.charAt(i) <= 'Z') {
          return false;
        }
      }
    } else {
      if (word.charAt(1) >= 'a') {
        for (int i = 2; i < word.length(); i++) {
          if (word.charAt(i) <= 'Z') {
            return false;
          }
        }
      } else {
        for (int i = 2; i < word.length(); i++) {
          if (word.charAt(i) >= 'a') {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    _520_DetectCapital obj = new _520_DetectCapital();
    System.out.println(obj.detectCapitalUse("USA"));
    System.out.println(obj.detectCapitalUse("Google"));
    System.out.println(obj.detectCapitalUse("FlaG"));
  }
}
