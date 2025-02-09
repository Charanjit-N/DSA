class LCM1838DoKModificationsToMakeMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        // TC-> O(n*logn) + O(n) = (approx) O(n*logn)
        // Sc->O(1)
        int len = nums.length;
        Arrays.sort(nums);       // O(n*logn)
        int l=0,r=0;
        int total =0, ans=0;
        while(r<len){                 // O(n)
            total = total + nums[r];
            while(nums[r]*(r-l+1) > total + k){
                total =  total - nums[l];
                l++;
            }
            ans = Math.max(ans, r-l+1 );
            r++;  
        }
        
        return ans;
        
    }
}