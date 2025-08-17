class TUFFindHowManyTimeArrayIsRotated {
    public int findKRotation(int[] nums) {
        // TC --> O(logn)
        int low = 0, high = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minIndex =  -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[high]) {
                if(nums[low] < minVal){
                    minVal = nums[low];
                    minIndex = low;
                }
                break;
            }
            if (nums[low] <= nums[mid]) {
                if(nums[low] < minVal){
                    minVal = nums[low];
                    minIndex = low;
                }
                low = mid + 1;

            } 
            else { 
                 if(nums[mid] < minVal){
                    minVal = nums[mid];
                    minIndex = mid;
                }
                high = mid - 1;
            }
        }
        return minIndex;
    }
}