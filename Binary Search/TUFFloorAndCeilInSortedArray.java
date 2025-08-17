// TC ->O( 2* logn ) = O(logn), SC->O(1)
class Solution {
    int ceil(int[] nums, int x){    // it is lowerbound
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                ans = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
    int floor(int[] nums, int x){
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= x) {
                ans = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }
    public int[] getFloorAndCeil(int[] nums, int x) {
       int c =  ceil(nums, x);
       int cVal = nums[c];
       int f = floor(nums, x);
       int fVal =  nums[f];
    
       return new int[]{fVal,cVal};
    }
}