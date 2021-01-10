/** https://www.hackerrank.com/challenges/kangaroo/problem */

package hackerRank;

class kangaroo {

  String kangaroo(int x1, int v1, int x2, int v2) {

    int k1 = x1;
    int k2 = x2;
    for (int i = 0; i < 10000; i++) {
      if (k1 == k2) {
        return "YES";
      }
      k1 = k1 + v1;
      k2 = k2 + v2;
    }
    return "NO";
  }
}
