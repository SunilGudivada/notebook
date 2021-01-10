package leetCode.problems;

/**
 * Given two version numbers, version1 and version2, compare them.
 *
 * <p>Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists
 * of digits and may contain leading zeros. Every revision contains at least one character.
 * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next
 * revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 *
 * <p>To compare version numbers, compare their revisions in left-to-right order. Revisions are
 * compared using their integer value ignoring any leading zeros. This means that revisions 1 and
 * 001 are considered equal. If a version number does not specify a revision at an index, then treat
 * the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s
 * are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * <p>Return the following:
 *
 * <p>If version1 < version2, return -1. If version1 > version2, return 1. Otherwise, return 0.
 *
 * <p>Example 1:
 *
 * <p>Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes,both "01" and "001" represent the same integer "1".
 *
 *
 * Example 2:
 *
 * <p>Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: version1 does not specify revision 2, which means it is treated as "0".
 *
 * Example 3:
 *
 * <p>Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
 *
 *
 * Example 4:
 *
 * <p>Input: version1 = "1.0.1", version2 = "1" Output: 1
 *
 * Example 5:
 *
 * <p>Input: version1 = "7.5.2.4", version2 = "7.5.3" Output: -1
 *
 * <p>Constraints:
 *
 * <p>1 <= version1.length, version2.length <= 500
 * version1 and version2 only contain digits and '.'. version1 and version2 are valid version numbers.
 * All the given revisions in version1 and version2 can be stored in a 32-bit integer.
 */
public class _165_compareVersionNUmber {
  public static int compareVersions(String version1, String version2){

    String [] str1 = version1.split("\\.");
    String [] str2 = version2.split("\\.");

    int i=0, j=0;

    for(i=0,j=0; i<str1.length && j<str2.length; i++,j++){
      int a = Integer.parseInt(str1[i]);
      int b = Integer.parseInt(str2[j]);

      if(a == b) continue;

      return a>b ? 1 : -1;
    }

    while(i<str1.length){
      if(Integer.parseInt(str1[i]) > 0) return 1;

      i++;
    }

    while(j<str2.length){
      if(Integer.parseInt(str2[j]) > 0) return -1;

      j++;
    }

    return 0;
  }
  public static void main(String[] args){
    System.out.println(compareVersions("1.5","1.1.8"));
  }
}
