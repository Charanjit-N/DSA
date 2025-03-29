class LCM525LongestSubarrayWithEqual0sAnd1sInBinaryArray. {
    public int findMaxLength(int[] nums) {
        //Optimal : TC->o(n) , SC->o(n)->{For using hashmap}
        /*Intution : Consider 0's as -1's , So the subarray whose sum = 0 will have the equal no.of 0's and 1's
          Now apply the running sum hashing technique same as in GFG_Longest subarray with sum = k, here for 
          this problem take k=0. This similar kind of technique/pattern is also used in leetcode 560_Count SubArrays whose sum=k
          */
        int n = nums.length;
        int preSum = 0;
        int maxLen =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++)
        {
            // if(nums[i]==0){ preSum = preSum + (-1);}
            // else{ preSum =preSum+nums[i]; }
            preSum += (nums[i]==0) ? -1 : nums[i];
            
            if(map.containsKey(preSum)){
                int len = i - map.get(preSum);
                maxLen = Math.max(maxLen , len);
            }
            else{
                map.put(preSum,i);
            }
        }
        return maxLen;
    }
}