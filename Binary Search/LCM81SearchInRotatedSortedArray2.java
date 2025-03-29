class LCM81SearchInRotatedSortedArray2 {

    //Optimal (Binary Search) :TC->O(logn) , SC->O(1)
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]== target) return true;

            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            //if left part of mid in the array is sorted
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            // if right part of mid in the array is sorted
            else{
                if(nums[mid]<target && target<=nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;


        // Brute Force : Linear Search : TC-> O(n), SC-> O(1)
        // for(int i =0;i<nums.length;i++){
        //     if(nums[i]==target) return true;
        // }
        // else return false;
        

    }
}