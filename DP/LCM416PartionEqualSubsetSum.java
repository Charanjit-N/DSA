
// Recursion :  TC->O(2^n), SC->O(n) recursion stack space
class Solution {
    boolean solve(int index, int target, int[] nums){
        if(index == 0) return nums[0] == target;
        if(target ==0) return true;
        boolean notPick = solve(index-1, target , nums);
        boolean pick = false;
        if(nums[index] <= target) pick = solve(index-1, target-nums[index], nums);
        return pick || notPick;
    }
    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
       for(int i=0; i<n;i++){
        totalSum += nums[i];
       }
       if(totalSum % 2 !=0) return false;
       int target = totalSum/2;
       return solve(n-1,target , nums);
    }
}

// Memoization :  TC->O(n x target) + O(n) , SC->O(n) recursion stack space + o(n x target) : dp array
class Solution {
    static boolean solve(int index,  int target , int[] nums,int[][] dp){
       if(target == 0) return true;
       if(index ==0) return nums[index] == target;
       if(dp[index][target] != -1) return (dp[index][target]==1) ? true: false;
       boolean notPick = solve(index-1, target , nums,dp);
       boolean pick  = false;
       if(nums[index] <= target) {
        pick = solve(index-1, target - nums[index] , nums,dp);
       }
       dp[index][target] = (pick || notPick) ==true ? 1 : 0;
       return  pick || notPick;
    }
    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
       for(int i=0; i<n;i++){
        totalSum += nums[i];
       }
       if(totalSum % 2 !=0) return false;
       int target = totalSum/2;
       int[][] dp =  new int[n][target+1];
       for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
       return solve(n-1,target , nums,dp);
    }
}


// Tabulation :  TC->O(n x target) +O(n), SC-> o(n x target) : dp array
class Solution {
    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
       for(int i=0; i<n;i++){
        totalSum += nums[i];
       }
       if(totalSum % 2 !=0) return false;
       int target = totalSum/2;
        boolean[][] dp =  new boolean[n][target+1];
        // base case : if(target == 0) return true;
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
       //base case: if(index ==0) return nums[index] == target;
        if(nums[0]<=target) dp[0][nums[0]] = true ;
        for(int index =1;index<n;index++){
            for(int tar = 1;tar<=target;tar++){
                boolean notPick = dp[index-1][tar];
                boolean pick  = false;
                if(nums[index] <= tar) {
                    pick = dp[index-1][tar - nums[index]];
                }
                dp[index][tar] = pick || notPick;
            }
        }
        return dp[n-1][target];
    }
}



// Tabulation with space optimization:  TC->O(n x target) +O(n), SC-> O(target) : extra arrays
class Solution {
    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
       for(int i=0; i<n;i++){
        totalSum += nums[i];
       }
       if(totalSum % 2 !=0) return false;
       int target = totalSum/2;
        boolean[] prev =  new boolean[target+1];
        boolean[] cur =  new boolean[target+1];
        prev[0] = cur[0] = true;
        if(nums[0]<=target) prev[nums[0]] = true ;
        for(int index =1;index<n;index++){
            for(int tar = 1;tar<=target;tar++){
                boolean notPick = prev[tar];
                boolean pick  = false;
                if(nums[index] <= tar) {
                    pick = prev[tar - nums[index]];
                }
                cur[tar] = pick || notPick;
            }
            for(int x=0;x<=target;x++){
                prev[x] = cur[x];
            }
        }
        return prev[target]; 
    }
}