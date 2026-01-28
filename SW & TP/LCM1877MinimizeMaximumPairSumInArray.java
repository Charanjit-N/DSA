// TC ->O(n Logn)
class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l=0;
        int r = n-1;
        int maxSum = 0;
        while(l < r){
            maxSum = Math.max(maxSum, nums[l]+nums[r]);
            l++;
            r--;
        }
        return maxSum;
    }
}