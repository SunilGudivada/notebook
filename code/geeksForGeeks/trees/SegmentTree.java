package geeksForGeeks.trees;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * range search time complexity : O(log n)
 * tree construction time complexity is O(n) Space
 * complexity : O(n)
 */
public class SegmentTree {

  private int[] treeArray;
  private int[] originalArray;
  private BiFunction<Integer, Integer, Integer> operation;
  private int defaultValue;

  public SegmentTree(
      int[] array, BiFunction<Integer, Integer, Integer> operation, int defaultValue) {
    assert array.length != 0;
    assert operation != null;

    originalArray = array;
    this.operation = operation;
    this.defaultValue = defaultValue;
    int height = (int) Math.ceil(Math.log(array.length) / Math.log(2));

    // tree size = 2 * (2 ^ height) - 1
    int treeSize = 2 * (int) Math.pow(2, height) - 1;

    treeArray = new int[treeSize];
  }

  public void build() {
    buildSegmentTree(0, originalArray.length - 1, 0, originalArray);
  }

  public int findOutputIn(int startIndex, int endIndex) {
    return findOutputIn(0, originalArray.length - 1, startIndex - 1, endIndex - 1, 0);
  }

  private int findOutputIn(
      int segmentStartIndex,
      int segmentEndIndex,
      int rangeStartIndex,
      int rangeEndIndex,
      int segmentIndex) {
    // System.out.println("Finding output in " + segmentStartIndex + " and " + segmentEndIndex);

    if (segmentStartIndex >= rangeStartIndex && segmentEndIndex <= rangeEndIndex) {
      return treeArray[segmentIndex];
    }

    if (segmentStartIndex > rangeEndIndex || segmentEndIndex < rangeStartIndex) {
      // System.out.println("Return Default");
      return defaultValue;
    }

    int mid = (segmentStartIndex + segmentEndIndex) / 2;
    int leftChildSegmentIndex = 2 * segmentIndex + 1;
    int rightChildSegmentIndex = 2 * segmentIndex + 2;
    return operation.apply(
        findOutputIn(segmentStartIndex, mid, rangeStartIndex, rangeEndIndex, leftChildSegmentIndex),
        findOutputIn(
            mid + 1, segmentEndIndex, rangeStartIndex, rangeEndIndex, rightChildSegmentIndex));
  }

  private int buildSegmentTree(
      int segmentStartIndex, int segmentEndIndex, int segmentIndex, int[] array) {

    if (segmentStartIndex == segmentEndIndex) {
      treeArray[segmentIndex] = array[segmentStartIndex];
      return array[segmentStartIndex];
    }

    int mid = (segmentStartIndex + segmentEndIndex) / 2;
    int leftChildSegmentIndex = 2 * segmentIndex + 1;
    int rightChildSegmentIndex = 2 * segmentIndex + 2;
    treeArray[segmentIndex] =
        this.operation.apply(
            buildSegmentTree(segmentStartIndex, mid, leftChildSegmentIndex, array),
            buildSegmentTree(mid + 1, segmentEndIndex, rightChildSegmentIndex, array));
    return treeArray[segmentIndex];
  }

  @Override
  public String toString() {
    return "Given Tree: "
        + Arrays.toString(originalArray)
        + "\nSegment Tree: "
        + Arrays.toString(treeArray);
  }
}
