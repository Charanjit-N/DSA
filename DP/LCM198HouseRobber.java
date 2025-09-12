// Recursion , TC-> exponential
class Solution {
    static int robber(int index,int[] nums){
        if(index == nums.length-1) return nums[index];
        if(index >= nums.length) return  0;

        int pick  = nums[index] + robber(index+2, nums);
        int notPick =  0 + robber(index+1, nums);
        return Math.max(pick, notPick); 
    }
    static int rob(int[] nums) {
       return  robber(0,nums);
    }
}

// Recursion , TC-> exponential
class Solution {
    int robber(int index,int[] nums){
        if(index == 0) return nums[index];
        if(index < 0) return  0;

        int pick  = nums[index] + robber(index-2, nums);
        int notPick =  0 + robber(index-1, nums);
        return Math.max(pick, notPick); 
    }
    public int rob(int[] nums) {
       return  robber(nums.length-1,nums);
    }
}

// Memoization : TC->O(n), SC->O(n+n)

class Solution {
    int robber(int index,int[] nums, int[] dp){
        if(index == 0) return nums[index];
        if(index < 0) return  0;
       
        if(dp[index] != -1) return dp[index];

        int pick  = nums[index] + robber(index-2, nums,dp);
        int notPick =  0 + robber(index-1, nums,dp);

        return dp[index] = Math.max(pick, notPick); 
    }
    public int rob(int[] nums) {
        int n = nums.length;
       int[] dp = new int[n];
       Arrays.fill(dp,-1);
       return  robber(n-1,nums, dp);
    }
}



// Tabulation : TC->O(N), SC->O(N)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
       int[] dp = new int[n];
       dp[0] = nums[0];
       for(int i=1;i<n;i++){
            int pick   =  nums[i];
            if(i > 1){
                pick = pick + dp[i-2];
            }
            int notPick = 0 + dp[i-1];
            dp[i] =  Math.max(pick, notPick);
       }
       return  dp[n-1];
    }
}

// Tabulation space optimization : TC->O(N), SC->O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
       int prev1 = nums[0];
       int prev2 = 0;
       for(int i=1;i<n;i++){
            int pick   =  nums[i];
            if(i > 1){
                pick = pick + prev2;
            }
            int notPick = 0 + prev1;
            int curr=  Math.max(pick, notPick);
            prev2 =  prev1;
            prev1 =curr;
       }
       return  prev1;
    }
}