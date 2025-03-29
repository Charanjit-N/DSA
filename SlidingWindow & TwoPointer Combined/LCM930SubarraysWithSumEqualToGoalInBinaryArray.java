class LCM930SubarraysWithSumEqualToGoalInBinaryArray {       //-> Similar to LCM560 problem
    // This function returns the total no.of subarrays having sum <= goal
    int func(int[] nums,int goal){    // TC->O(2N) , SC->O(1)
        if(goal<0) return 0;
        int n= nums.length;
        int l=0,r=0;
        int cnt = 0;
        int sum =0;
        while(r<n){
            sum = sum + nums[r];
            while(sum>goal){
                sum = sum - nums[l];
                l++;
            }
            cnt = cnt + (r-l+1); 
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
    
        // Optimal : (variable Sliding window using two pointers and sliding window combined)
        // TC->(2*(2N))=O(4N) , SC->O(1)
        return func(nums,goal) - func(nums,(goal-1));


        // Better: (Hashing) (same as Leetcode 560) : TC->O(N) , SC->O(N)  
        // Map<Integer,Integer> map = new HashMap<>();
        // int preSum =0;
        // int cnt = 0;
        // map.put(0,1);
        // for(int i=0;i<nums.length;i++){
        //     preSum +=nums[i];
        //     int rem = preSum - goal;
        //     cnt+=map.getOrDefault(rem,0);
        //     map.put(preSum,map.getOrDefault(preSum,0)+1);
        // }
        // return cnt;


        // Brute 2 : TC->O(N^2) , SC->O(1)
        // int n = nums.length;
        // int cnt = 0;
        // for(int i=0;i<n;i++){
        //     int sum =0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];
        //         if(sum == goal) cnt++;
        //     }
        // }
        // return cnt;


        // Brute 1 : TC->O(N^3) , SC->O(1)
        // int n = nums.length;
        // int cnt = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int sum =0;
        //         for(int k=i;k<=j;k++){
        //             sum+=nums[k];
        //         }
        //         if(sum == goal) cnt++;
        //     }
        // }
        // return cnt;
        
    }
}