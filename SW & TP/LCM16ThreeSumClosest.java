// optimal : TC -- > O(n^2)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1;
            int right = n-1;
             while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum == target) {
                    return sum; 
                } else if (sum < target) {
                    left++;  
                } else {
                    right--; 
                }
            }
        }
        return ans;       
    }
}

