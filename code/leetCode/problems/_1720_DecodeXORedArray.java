package leetCode.problems;

public class _1720_DecodeXORedArray {
  public int[] decode(int[] encoded, int first) {
    int n = encoded.length;
    int[] res = new int[n + 1];
    res[0] = first;
    for (int i = 0; i < n; ++i) res[i + 1] = res[i] ^ encoded[i];
    return res;
  }
}
