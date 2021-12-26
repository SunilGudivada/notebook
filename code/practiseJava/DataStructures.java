package practiseJava;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DataStructures {

    public static void ArrayDS() {
        int[] arr = new int[100];
        Arrays.fill(arr, 10);

        for(int i=0;i<100;i++) arr[i] = i;

        System.out.println(Arrays.toString(arr));

        /*
          Correct ways to copy array as listed below as follows:

          @docs https://www.geeksforgeeks.org/array-copy-in-java/

          Iterating each element of the given original array and copy one element at a time
          Using clone() method
          Using arraycopy() method
          Using copyOf() method of Arrays class
          Using copyOfRange() method of Arrays class
         */

        int iteratedArray[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            iteratedArray[i] = arr[i];

        int[] clonedArray = arr.clone();
        System.out.println("Cloned Array::: " + Arrays.toString(clonedArray));

        int[] arrayCopy = new int[arr.length];
        System.arraycopy(arr, 0 , arrayCopy, 0, 3);
        System.out.println("System Array Copy::: "+Arrays.toString(arrayCopy));


        int[] copiedArr = Arrays.copyOfRange(arr, 2 , 4);

        System.out.println("Copied Of Range::: "+Arrays.toString(copiedArr));

        System.out.println("Print Deep String::: " + Arrays.deepToString(new int[][]{{1,2},{3,4}}));

        // Sort by range
        Arrays.sort(arr, 4, 6);

        // Check equality condition by range
//        System.out.println("Array equals by Range :::"+ Arrays.equals(arr, 2,4, copiedArr, 0 ,2 ));

        // Arrays.mismatch(int[] a , int[] b ) -> returns the first index of mismatch
//        System.out.println("Mismatched Index:: " +Arrays.mismatch(new int[]{1,2,3,4}, new int[]{1,2,3,3}));

    }

    /**
     * Notes:
     *
     * 1. Priority Queue don't accepts null pointer
     */
    public static void PriorityQueueDS(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int size = pq.size();

        pq.add(23);
        pq.contains(23);
    }

    public static void SetDS(){}

    public static void LinkedListDS(){}

    public static void StackDS(){}

    public static void queueDS(){}

    public static void TreeDS(){}

    public static void GraphDS(){}

    public static void TableDS(){}

    public static void main(String[] args) {
        ArrayDS();
    }

}
