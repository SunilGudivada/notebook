package leetCode.problems.contest;

public class _5629_ReformatPhoneNumber {
  public String reformatNumber(String number) {
    number = number.replace("-", "");
    number = number.replace(" ", "");
    char[] arr = number.toCharArray();
    StringBuilder sb = new StringBuilder();
    int index = 0, count = number.length();
    while (count > 4) {
      for (int i = 0; i < 3; i++) {
        sb.append(arr[index++]);
        count--;
      }
      sb.append('-');
    }
    if (count < 4) {
      for (int i = 0; i < count; i++) {
        sb.append(arr[index++]);
      }
    } else {
      for (int i = 0; i < 2; i++) {
        sb.append(arr[index++]);
      }
      sb.append('-');
      for (int i = 0; i < 2; i++) {
        sb.append(arr[index++]);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    _5629_ReformatPhoneNumber obj = new _5629_ReformatPhoneNumber();
    System.out.println(obj.reformatNumber("1-23-45"));
  }
}
