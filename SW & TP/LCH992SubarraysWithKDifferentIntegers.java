class LCH992SubarraysWithKDifferentIntegers {
    // This function returns the total no.of subarrays having number of different integers <= k 
    int func(int[] nums,int k){    // TC->O(2N) , SC->O(N){using Map}
        int n= nums.length;
        int l=0,r=0;
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size() > k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            cnt = cnt + (r-l+1); 
            r++;
        }
        return cnt;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        // Optimal : (variable Sliding window using two pointers and sliding window combined) 
        // TC->(2*(2N))=O(4N) , SC->O(2N)
        
        return func(nums,k) - func(nums,(k-1));
        

        // Brute Force : TC->O(n^2) , SC->O(N)
        // int n = nums.length;
        // int cnt = 0;
        // for(int i=0;i<n;i++){
        //     Map<Integer,Integer> map = new HashMap<>();
        //     for(int j=i;j<n;j++){
        //         map.put(nums[j],1);
        //         if(map.size()==k){
        //             cnt++;
        //         }
        //         else if(map.size()>k) break;
        //     }
        // }
        // return cnt;
    }
}