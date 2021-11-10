package geeksForGeeks.arrays;

import java.util.*;

/**
 * Geek Land has a population of N people and each person's ability to rule the town is
 * measured by a numeric value arr[i]. The two people that can together
 * rule Geek Land must be compatible with each other i.e.,
 * the sum of digits of their ability arr[i] must be equal.
 * Their combined ability should be maximum amongst all the possible pairs
 * of people. Find the combined ability of the Ruling Pair.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * arr[] = {55, 23, 32, 46, 88}
 *
 * Output:
 * 101
 *
 * Explanation:
 * All possible pairs that are
 * compatible with each other are- (23, 32)
 * with digit sum 5 and (55, 46) with digit
 * sum 10. Out of these the maximum combined
 * ability pair is (55, 46) i.e. 55 + 46 = 101
 *
 * Example 2:
 *
 * Input:
 * N = 4
 * arr[] = {18, 19, 23, 15}
 *
 * Output:
 * -1
 *
 * Explanation:
 * No two people are compatible with each other.
 */
public class RulingPair {

    public int solve(int arr[], int n){

        int maxSum = -1;
        HashMap<Integer, Integer> digitMaxMap = new HashMap<>();
        for(int num:arr) {
            int digitSum = 0;
            int tmp = num;
            while(tmp>0) {
                digitSum += tmp%10;
                tmp=tmp/10;
            }
            Integer maxVal = digitMaxMap.get(digitSum);
            if( maxVal == null) {
                digitMaxMap.put(digitSum, num);
            }else {
                int sum = maxVal+num;
                maxSum = Math.max(maxSum, sum);
                if(num>maxVal) {
                    digitMaxMap.put(digitSum, num);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int n = 5;
        int arr[] = new int[]{55,23,41,32,46,88};
        System.out.println(new RulingPair().solve(arr, n));
    }
}
