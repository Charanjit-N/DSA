class LCM1248SubarraysWithNoOfOddNumbersEqualToK{

    // This function returns the total no.of subarrays having number of odd numbers(i.e., sum) <= k 
    int func(int[] nums,int k){    // TC->O(2N) , SC->O(1)
        int n = nums.length;
        int left = 0, right = 0,oddCount = 0, result = 0;
        while(right <  n) {
            if (nums[right] % 2 ==1 ) oddCount++;
            while (oddCount > k) {
                if (nums[left] % 2 == 1) oddCount--;
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
        
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