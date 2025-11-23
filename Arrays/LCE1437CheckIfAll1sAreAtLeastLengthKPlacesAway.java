// TC --> O(n)
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int gap = 0;
        boolean foundFirstOne = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(gap < k && foundFirstOne) return false;
                if(foundFirstOne == false) foundFirstOne = true;
                gap = 0;
            }else{ 
                gap++;
            }
        }
        return true;
        
    }
}