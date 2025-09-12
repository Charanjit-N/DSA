// Iterative Solution TC->O(log n) base 2
int bs(){
    int low =0;
    int high = n-1;
    while(low <= high){
        int mid  = low + (high - low)/2;
        if(nums[mid] == target){
            retturn mid;
        }
        else if(target < nums[mid]){
            high = mid-1;
        }
        else{
            low =  mid+1;
        }
    }
    return -1;
}

// Recursive Solution TC->O(log n) base 2
// Extra O(log n ) recursion stack space
int bs(int[] nums, int low, int high, int target){
    if(low >  high ) return -1;

    int mid = low + (high - low)/2;
    
    if(nums[mid] == target){
        return mid;;
    }
    else if(target < nums[mid]){
        return bs(nums, low, mid-1, target);
    }
    else{
       return bs(nums, mid+1, high, target);
    }
}
int solve(int[] nums){
    return bs(nums, 0, nums.length-1,target);
}