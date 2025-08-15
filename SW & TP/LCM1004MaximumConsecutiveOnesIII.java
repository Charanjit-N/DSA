class LCM1004MaximumConsecutiveOnesIII {
    
    public int longestOnes(int[] nums, int k) {
        // Optimal 2: TC->O(N) , SC->O(1)
         int n = nums.length;
        int maxLen =0;
        int left=0, right=0;
        int zeros=0;
        while(right<n){     
            if(nums[right]==0) {zeros++;}
            if(zeros>k){
                if(nums[left]==0) { zeros--;}
                left++;  
            }
            if(zeros <=k){
                maxLen = Math.max(maxLen , (right-left+1));
            }

            right++;
        }
        return maxLen;


        // Optimal 1 :  TC->O(2N) , SC->O(1)
        // int n = nums.length;
        // int maxLen =0;
        // int left=0, right=0;
        // int zeros=0;
        // while(right<n){     
        //     if(nums[right]==0) { zeros++; }    // we can also write this like :zeros += (!nums[right])
        //     while(zeros>k){
        //         if(nums[left]==0) { zeros--; }
        //         left++;
        //     }

        //     if(zeros <=k){
        //         maxLen = Math.max(maxLen , (right-left+1));
        //     }

        //     right++;
        // }
        // return maxLen;



        //Better : TC->O(n^2) , SC->O(1)
        // int n = nums.length;
        // int maxLen  = 0;
        // for(int i=0;i<n;i++){
        //     int zeros=0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]==0){
        //             zeros++;
        //         }
        //         if(zeros<=k){
        //             maxLen = Math.max(maxLen,j-i+1);
        //         }
        //         // If  zeros exceeds the k then there is no point in calculating subarrays starting at that "i" So break.
        //         else{
        //             break;
        //         }

        //     }
        // }
        // return maxLen;

    
        
    }
}