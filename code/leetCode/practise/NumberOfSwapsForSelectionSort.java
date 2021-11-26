package leetCode.practise;

import java.util.Arrays;
import java.util.LinkedList;

public class NumberOfSwapsForSelectionSort {

    public LinkedList<Integer> numberOfSwaps(int[] arr) {
        LinkedList<Integer> result = new LinkedList<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public int numberOfSwaps(LinkedList<Integer> nums) {
        int count = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums.get(j) < nums.get(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 2};
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println(new NumberOfSwapsForSelectionSort().numberOfSwaps(arr));
        System.out.println(new NumberOfSwapsForSelectionSort().numberOfSwaps(list));
    }
}
