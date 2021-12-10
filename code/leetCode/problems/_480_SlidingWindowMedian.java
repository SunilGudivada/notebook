package leetCode.problems;

import java.util.Arrays;

public class _480_SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        double[] median = new double[n-k+1];

        for(int i=0;i<n-k+1;i++){
            int[] arr = Arrays.copyOfRange(nums, i, i+k);

            Arrays.sort(arr);

            if(k%2 == 0){
                median[i] = ((double) arr[k/2] + (double) arr[k/2-1])/2.0;
            }else{
                median[i] = (double) arr[k/2];
            }
        }

        return median;
    }
}
