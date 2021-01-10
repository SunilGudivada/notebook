package leetCode.problems;

/**
 * You are given two images img1 and img2 both of size n x n, represented as binary, square matrices
 * of the same size. (A binary matrix has only 0s and 1s as values.)
 *
 * <p>We translate one image however we choose (sliding it left, right, up, or down any number of
 * units), and place it on top of the other image. After, the overlap of this translation is the
 * number of positions that have a 1 in both images.
 *
 * <p>(Note also that a translation does not include any kind of rotation.)
 *
 * <p>What is the largest possible overlap?
 *
 * <p>Example 1:
 *
 * <p>Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]] Output: 3
 * Explanation: We slide img1 to right by 1 unit and down by 1 unit.
 *
 * <p>The number of positions that have a 1 in both images is 3. (Shown in red)
 *
 * <p>Example 2:
 *
 * <p>Input: img1 = [[1]], img2 = [[1]] Output: 1 Example 3:
 *
 * <p>Input: img1 = [[0]], img2 = [[0]] Output: 0
 *
 * <p>Constraints:
 *
 * n == img1.length
 * n == img1[i].length
 * n == img2.length
 * n == img2[i].length
 * 1 <= n <= 30
 * img1[i][j] is 0 or 1.
 * img2[i][j] is 0 or 1.
 */
public class _835_imageOverlap {
  protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
    int count = 0;
    int rRow = 0;
    for (int mRow = yShift; mRow < M.length; ++mRow) {
      int rCol = 0;
      for (int mCol = xShift; mCol < M.length; ++mCol) {
        if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
          count += 1;
        rCol += 1;
      }
      rRow += 1;
    }
    return count;
  }
  public int largestOverlap(int[][] A, int[][] B) {
    int maxOverlaps = 0;

    for (int yShift = 0; yShift < A.length; ++yShift)
      for (int xShift = 0; xShift < A.length; ++xShift) {
        maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
        maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
      }

    return maxOverlaps;
  }
}
