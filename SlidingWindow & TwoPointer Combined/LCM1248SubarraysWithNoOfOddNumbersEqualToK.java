class LCM1248SubarraysWithNoOfOddNumbersEqualToK{

    // This function returns the total no.of subarrays having number of odd numbers(i.e., sum) <= k 
    int func(int[] nums,int k){    // TC->O(2N) , SC->O(1)
        if(k<0) return 0;
        int n= nums.length;
        int l=0,r=0;
        int cnt = 0;
        int odd =0;
        while(r<n){
            if(nums[r]%2==1) odd++;
            while(odd > k){
                if(nums[l]%2==1) odd--;
                l++;
            }
            cnt = cnt + (r-l+1); 
            r++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        // This question is same as (Leetcode 930): Given an array having 1's and 0's count the subarrays whose sum = k.

        // Optimal : (variable Sliding window using two pointers and sliding window combined) 
        // TC->(2*(2N))=O(4N) , SC->O(1)
        return func(nums,k) - func(nums,(k-1));


        // Brute(TLE): TC->O(n^2) , SC->O(1)
        // int n = nums.length;
        // int cnt=0;
        // for(int i=0;i<n;i++){
        //     int odd = 0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]%2==1) odd++;
        //         if(odd==k){
        //             cnt++;
        //         }
        //         if(odd>k) break;
        //     }
        // }
        // return cnt;
        
    }
}