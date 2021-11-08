package geeksForGeeks.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSumNonOverlappingInternalScheduling {

    static int solve(int[][] interval){
        Arrays.sort(interval , Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int max = 0;
        int result = 0;

        for(int[] e : interval){
            while (!pq.isEmpty()){
                if(pq.peek()[0] >= e[0]){

                    System.out.println(Arrays.toString(e));
                    break;
                }


                int[] peekElement = pq.remove();
                max = Math.max(max, peekElement[1]);
            }

            result = Math.max(result, max+e[2]);
            pq.add(new int[]{e[1],e[2]});
        }
        return result;
    }
    public static void main(String[] args){
        int[][] interval
                = { { 1, 3, 2 },
                { 4, 5, 2 },
                { 1, 5, 5 } };
        int maxValue
                = MaxSumNonOverlappingInternalScheduling.solve(interval);
        System.out.println(maxValue);
    }
}
