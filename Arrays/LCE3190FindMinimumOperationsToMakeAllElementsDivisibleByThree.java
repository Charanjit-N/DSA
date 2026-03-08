// TC -->O(n)
class Solution {
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] %3 != 0) ops++;
        }
        return ops;
    }
}