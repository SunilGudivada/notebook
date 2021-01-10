package leetCode.problems;

import java.util.ArrayList;

public class _6_ZigZagConversion {
  public String convert(String s, int numRows) {
    if (s.length() == 1 || numRows == 1) {
      return s;
    }
    int[] posArr = new int[s.length()];
    int j = 0;
    boolean down = true;
    numRows--;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (down) {
        posArr[i] = j;
        j++;
      } else {
        posArr[i] = j;
        j--;
      }
      if (j == numRows && down) {
        down = false;
      }
      if (j == 0 && !down) {
        down = true;
      }
    }
    for (int i = 0; i <= numRows; i++) {
      for (j = 0; j < s.length(); j++) {
        if (posArr[j] == i) {
          sb.append(s.charAt(j));
        }
      }
    }
    return sb.toString();
  }

  public String convert2(String s, int numRows) {
    if (numRows <= 1) return s;
    ArrayList<String> res = new ArrayList<>();
    for (int i = 0; i < numRows; i++) res.add("");
    int row = 0;
    int step = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      res.set(row, res.get(row) + c);
      if (row == 0) step = 1;
      if (row == numRows - 1) step = -1;
      row += step;
    }
    StringBuilder result = new StringBuilder();
    for (String str : res) result.append(str);
    return result.toString();
  }

  public static void main(String[] args) {
    _6_ZigZagConversion obj = new _6_ZigZagConversion();
    System.out.println(obj.convert2("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
  }
}
