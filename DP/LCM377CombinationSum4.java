// Recursion  TC -> O(N^target) roughly (Exponential), SC->O(target) worst case recursion stack space
class Solution {
    private int solve(int target , int[] nums) {
        if (target == 0) return 1; 
        if (target < 0) return 0;
        int totalWays = 0;
        for (int num : nums) {
            totalWays += solve(target - num , nums);
        }
        return totalWays;
    }
    public int combinationSum4(int[] nums, int target) {
        return solve(target, nums);
    }
}


// Memoization :  TC-> O(n x target),SC->O(target):recursion stack space + O(tarrget) : dp array
class Solution {
    int solve(int target , int[] nums,int[] dp) {
        if (target == 0) return 1; 
        if (target < 0) return 0;
        if(dp[target]  != -1) return dp[target];   
        int totalWays = 0;
        for (int num : nums) {
            totalWays += solve(target - num , nums,dp);
        }
        return dp[target] = totalWays;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp =  new int[target+1];
        Arrays.fill(dp,-1);
        return solve(target, nums,dp);
    }
}

// Tabulation :  TC-> O(n x target) ,SC-> O(tarrget) : dp array
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp =  new int[target+1];
        dp[0] = 1;
        for(int tar=1;tar<=target;tar++){
            int totalWays = 0;
            for (int num : nums) {
                if(num <= tar) totalWays += dp[tar - num];
            }
            dp[tar] = totalWays;
        }
        return dp[target];
    }
}
