// TC->O(n*logn), SC->O(1)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r =0;
        int jumps = 0;
        while(r<n-1){
            int maxReach = 0;
            for(int i=l;i<=r;i++){
                maxReach = Math.max(maxReach, i+nums[i]);
            }
            // if(maxReach <= r) return -1;  in case in an array if we cant reach to n-1 index 
            l=r+1;
            r = maxReach;
            jumps++;
        }
        return jumps;

    }
}