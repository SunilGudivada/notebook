package leetCode.problems;

public class _8_StringtoIntegeratoi {
  public int myAtoi(String str) {
    String s = str.trim();
    if ( s.equals("")) return 0;
    if ( s.length() == 1) {
      if (s.charAt(0) > 48 && s.charAt(0) < 58 ) return s.charAt(0) - '0';
      else return 0;
    }
    int n = s.length();
    int f = 0;
    char c = s.charAt(0);
    if (!( (c >= 48 && c <= 57) || c == '+' || c == '-' )) {
      return 0;
    }
    if ( c == '-'){
      f = -1;
    }
    else if ( c == '+' ){
      f = 1;
    }
    c = s.charAt(1);
    if (f != 0 && ( c < 48 || c > 57 )) return 0;
    int i = 0;
    int j = 0;
    i = f!=0 ? 1 : 0;
    while ( i < n ) {
      if ( s.charAt(i) == '0')
        i++;
      else
        break;
    }
    j = i;
    if ( i == n ) return 0;
    if (!( s.charAt(i) > 48 && s.charAt(i) < 58 )) return 0;
    while ( i < n ) {
      c = s.charAt(i);
      if ( c >= 48 && c <= 57)
        i++;
      else break;
    }
    if ( i == j && j > 1 ) return 0;
    if ( (i - j) > 10) {
      if ( f == -1)
        return Integer.MIN_VALUE;
      else
        return Integer.MAX_VALUE;
    }
    long l = Long.parseLong(s.substring(j, i));
    if (l > Integer.MAX_VALUE ) {
      if ( f == -1 )
        return Integer.MIN_VALUE;
      else
        return Integer.MAX_VALUE;

    }
    return (int)(f == 0 ? l : f * l);
  }

  public static void main(String[] args) {
    _8_StringtoIntegeratoi obj = new _8_StringtoIntegeratoi();
    System.out.println(obj.myAtoi("+words and 987"));
  }
}
