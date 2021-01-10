package leetCode.problems;

public class _4_MedianofTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0, j = 0;
    double[] res = new double[nums1.length + nums2.length];
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] > nums2[j]) {
        res[i + j] = nums2[j];
        j++;
      } else {
        res[i + j] = nums1[i];
        i++;
      }
    }
    while (i < nums1.length) {
      res[i + j] = nums1[i];
      i++;
    }
    while (j < nums2.length) {
      res[i + j] = nums2[j];
      j++;
    }
    double med;
    int index = res.length / 2;
    if (res.length % 2 == 0) {
      med = (res[index] + res[index - 1]) / 2;
    } else {
      med = res[index];
    }
    return med;
  }

  public static void main(String[] args) {
    _4_MedianofTwoSortedArrays obj = new _4_MedianofTwoSortedArrays();
    int[] nums1 = new int[]{};
    int[] nums2 = new int[]{1};
    System.out.println(obj.findMedianSortedArrays(nums1, nums2));
  }
}
