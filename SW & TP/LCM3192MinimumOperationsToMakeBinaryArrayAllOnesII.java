// TC ->O(n), SC->O(1)

class LCM3192MinimumOperationsToMakeBinaryArrayAllOnesII {
    public int minOperations(int[] nums) {
        int flipCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(flipCount % 2==0) flipCount++;
            }
            else{
                if(flipCount % 2 == 1) flipCount++;
            }
        }
        return flipCount;
        
    }
}