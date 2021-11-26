package leetCode.practise;

public class _4_medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] res = new int[n1 + n2];

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            res[i + j] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }

        while (i < n1) {
            res[i + j] = nums1[i++];
        }

        while (j < n2) {
            res[i + j] = nums2[j++];
        }

        int n = n1 + n2;

        if ((n & 1) == 0) {
            return (double) (res[n / 2] + res[(n - 1) / 2]) / 2;
        } else {
            return (double) res[n / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3,4};
        System.out.println(new _4_medianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
