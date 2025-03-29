class LCM3191MinimumOperationsToMakeBinaryArrayAllOnes{
    public int minOperations(int[] nums) {
        // TC-> O(3*n) = O(n) , SC->O(1)
        int n = nums.length;
        int l = 0;
        int r = 2;
        int cnt = 0;
        while(l>=0 && r<n){
            if(nums[l]==0){
                for(int i=l;i<=r;i++){
                    nums[i] =  1-nums[i];
                }
                cnt++;
            }
            l++;
            r++;
        }

        
        return (nums[n-2]==0 || nums[n-1]==0) ? -1 : cnt;
        
    }
}