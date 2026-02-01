// TC -> O(n)
class Solution {
    public int minimumCost(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i] < secondMin){
                if(nums[i] > min){
                    secondMin = nums[i];
                }else{
                    secondMin = min;
                    min = nums[i];
                }
            }
        }
        return nums[0]+ min + secondMin;
    }
}