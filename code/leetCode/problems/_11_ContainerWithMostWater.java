package leetCode.problems;

public class _11_ContainerWithMostWater {
  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length-1;
    int res =0;
    while(i<j){
      res = Math.max(res, (j-i)*Math.min(height[i], height[j]));
      if(height[i]<height[j]){
        i++;
      }else{
        j--;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    _11_ContainerWithMostWater obj = new _11_ContainerWithMostWater();
    int[] arr = new int[]{1,8,6,2,5,4,8,3,7}; // 49
    System.out.println(obj.maxArea(arr));
  }
}
