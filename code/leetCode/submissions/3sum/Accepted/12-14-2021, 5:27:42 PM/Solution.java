// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length == 0 ) return new ArrayList<>();
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0 ;i< nums.length -2;i++){
            if(i==0 || ( i >0 && nums[i] != nums[i-1] )){
                int low = i+1;
                int high = nums.length -1;
                int sum = 0 - nums[i];
                
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > sum){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }
        
        return res;
    }
}