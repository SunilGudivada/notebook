package leetCode.practise.googleInterviewQuestions;

/**
 * Given array of ints find largest distance between two unique numbers
 * e.g [1,2,4,1,5,2]
 * res = 5 which is dist from start to end
 */
public class DistUnqiueNumbers {

    public static int solve(int[] array){
        if(array.length ==0 ) return 0;

        int left = 0;
        int right = array.length-1;

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        while(left<=right){
            if(array[left] != array[right]){
                leftMax = right-left;
                break;
            }else{
                right--;
            }
        }
        if(leftMax == Integer.MIN_VALUE) return 0;
        left = 0;
        right = array.length-1;

        while(left<=right){
            if(array[left] != array[right]){
                rightMax = Math.max( right-left, rightMax);
                break;
            }else{
                left++;
            }
        }

        return Math.max(rightMax, leftMax);
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][]{{1,2,4,1,5,2}, {1,1,1}, {}, {1,2,4,1}, {1,1,1,6,1,1,1,1,1,1}};

        for (int[] testCase : testCases) {
            System.out.println(solve(testCase));
        }
    }
}
