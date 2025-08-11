// TC->O(n), SC->O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if(maxIndex >= n-1) break;
        }
        return true;
    }
}

