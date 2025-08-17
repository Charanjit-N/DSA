
// TC ->O(log n), SC->O(1)
class Solution {
    public int searchInnsertionPosition(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (nums[mid] >= x) {
                ans = mid;
                //so we look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // so look on the right
            }
        }
        return ans;
     }
}
