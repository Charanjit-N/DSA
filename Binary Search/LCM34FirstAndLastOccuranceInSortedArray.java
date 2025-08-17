// TC- >O(logn), SC->O(1)
class Solution {
    public int firstOccurance(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == x) {
                ans = mid;
                high = mid - 1;
            } 
            else if(nums[mid] < x) {
                low = mid + 1; 
            }
            else{
                high = mid-1;
            }
        }
        return ans;
     }
     public int lastOccurance(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == x) {
                ans = mid;
                low = mid + 1;
            } 
            else if(nums[mid] < x) {
                low = mid + 1; 
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first =  firstOccurance(nums, target);
        int last = lastOccurance(nums, target);
        return new int[]{first, last};
    }
}