class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = k-1;
        int diff =  Integer.MAX_VALUE;
        while(r < n){
            diff =  Math.min(diff , nums[r]-nums[l]);
            l++;
            r++;
        }
        return diff;
    }
}n