
// TC ->O(log n), SC->O(1)
class TUFUpperBound {
    public int upperBound(int[] nums, int x) {
       int n = nums.length;
       int low = 0, high = n - 1;
       int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (nums[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
