// Binary Search on Answers
// TC-> O(n * log(max in nums - min in nums)) , SC->O(1)
class LCM2560HouseRoberIV {     
    public int minCapability(int[] nums, int k) {
        int low =  Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            low =  Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        int ans = 0;
        while(low <= high){
            int mid =  low + (high - low)/2;
            if(check(mid, nums,k)){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    boolean check(int mid, int[] nums , int k){
        int n = nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=mid){
                cnt++;
                i++;
            }
        }
        return cnt>=k;
    }
}


// Recursion TC-> exponential  (TLE)
class LCM2560HouseRoberIV { 
    public int minCapability(int[] nums, int k) {
        return solve(0,nums,k,Integer.MIN_VALUE);
    }
    int solve(int index, int[] nums, int k , int maxSoFar){
        if(k==0) return maxSoFar;
        if(index >= nums.length) return Integer.MAX_VALUE;

        int rob = solve(index+2, nums, k-1, Math.max(maxSoFar, nums[index]));

        int skip =  solve(index+1, nums, k, maxSoFar);

        return Math.min(rob, skip);

    }

}