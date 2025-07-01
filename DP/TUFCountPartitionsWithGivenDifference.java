
// Recursion :TC->O(2^n) , SC->O(n) : recursion stack space
class Solution {
    static int solve(int index, int target , int[] nums){
        if(index==0){
            if(target ==0 && nums[0] == 0) return 2;
            if(target ==0 || target == nums[0]) return 1;
            return 0;
        }
        int notPick = solve(index-1, target, nums);
        int pick =0;
        if(nums[index] <= target) pick = solve(index-1, target-nums[index], nums);
        return pick + notPick;
    }
 public int countPartitions(int n, int diff, int[] arr) {
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum +=  arr[i];
        }
        if( totalSum-diff <0 || (totalSum-diff) %2==1 ) return 0;
        int target = (totalSum - diff)/2;
        return solve(n-1, target , arr);
    }
}



// Memoization :TC->O(nxtarget) , SC->O(n) : recursion stack space +O(nxtarget) : dp array
class Solution {
    static int solve(int index, int target , int[] nums,int[][] dp){
        if(index==0){
            if(target ==0 && nums[0] == 0) return 2;
            if(target ==0 || target == nums[0]) return 1;
            return 0;
        }
        if(dp[index][target]  != -1) return dp[index][target];
        int notPick = solve(index-1, target, nums,dp);
        int pick =0;
        if(nums[index] <= target) pick = solve(index-1, target-nums[index], nums,dp);
        return dp[index][target] = pick + notPick;
    }
    public int countPartitions(int n, int diff, int[] arr) {
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum +=  arr[i];
        }
        if( totalSum-diff <0 || (totalSum-diff) %2==1 ) return 0;
        int target = (totalSum - diff)/2;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(n-1, target , arr,dp);
    }
}



// Tabulation :TC->O(nxtarget) , SC->O(nxtarget) : dp array
class TUFCountPartitionsWithGivenDifference {
    public static int countPartitions(int n, int diff, int[] nums) {
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum +=  nums[i];
        }
        if( totalSum-diff <0 || (totalSum-diff) %2==1 ) return 0;
        int target = (totalSum - diff)/2;
        int[][] dp = new int[n][target+1]
       //base cases: 
        if(nums[0] ==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(nums[0]<=target && nums[0] != 0) dp[0][nums[0]] = 1 ;
        for(int index =1;index<n;index++){
            for(int tar = 0;tar<=target;tar++){
                int notPick = dp[index-1][tar];
                int pick  = 0;
                if(nums[index] <= tar) {
                    pick = dp[index-1][tar - nums[index]];
                }
                dp[index][tar] = pick + notPick;
            }
        }
       return dp[n-1][target];
    }
}


// Tabulation with space optimization :TC->O(nxtarget) , SC->O(target) : extra arrays
class TUFCountPartitionsWithGivenDifference {
    public static int countPartitions(int n, int diff, int[] nums) {
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum +=  nums[i];
        }
        if( totalSum-diff <0 || (totalSum-diff) %2==1 ) return 0;
        int target = (totalSum - diff)/2;
        int[] prev =  new int[target+1];
        int[] cur =  new int[target+1];
        //base cases: 
        if(nums[0] ==0) prev[0] = 2;
        else prev[0] = 1;
        if(nums[0]<=target && nums[0] != 0) prev[nums[0]] = 1 ;
        for(int index =1;index<n;index++){
            for(int tar = 0;tar<=target;tar++){
                int notPick = prev[tar];
                int pick  = 0;
                if(nums[index] <= tar) {
                    pick = prev[tar - nums[index]];
                }
                cur[tar] = pick+ notPick;
            }
            for(int x=0;x<=target;x++){
                prev[x] = cur[x];
            }
        }
        return prev[target];
    }
}