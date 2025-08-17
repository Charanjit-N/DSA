class Solution {
    public int findMin(int[] nums) {

        // TC --> O(logn)
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            // With below optimation also the code works
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            //if left part is sorted:
            if (nums[low] <= nums[mid]) {
                // keep the minimum:
                ans = Math.min(ans, nums[low]);

                // Eliminate left half:
                low = mid + 1;

            } 
            //if right part is sorted:
            else { 

                // keep the minimum:
                ans = Math.min(ans, nums[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
        // Brute Force : Finding where the dip is happening. TC -> O(n)
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]<nums[i-1]){
        //         return nums[i];
        //     }
        // }
        // return nums[0];
        
    }
}