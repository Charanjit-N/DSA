/*
Give an array count the number of different subsets whose sum equals given target
*/

// Recursion :TC->O(2^n) , SC->O(n) : recursion stack space
class CountSubsetsWithSumk{
    static int solve(int index, int target , int[] nums){
        if(target == 0) return 1;
        if(index==0){
            if(nums[0] == target) return 1;
            else return 0;
        }

        int notPick = solve(index-1, target, nums);
        int pick =0;
        if(nums[index] <= target) pick = solve(index-1, target-nums[index], nums);
        return pick + notPick;
    }
    public static void main(String args[]){
        int[] nums = {1,2,2,3};
        int target = 3;
        int n = nums.length;
        System.out.println(solve(n-1, target , nums));
    }
}

// Memoization :TC->O(nxtarget) , SC->O(n) : recursion stack space +O(nxtarget) : dp array
class CountSubsetsWithSumk{
    static int solve(int index, int target , int[] nums, int[][] dp){
        if(target == 0) return 1;
        if(index==0){
            if(nums[0] == target) return 1;
            else return 0;
        }
        if(dp[index][target]  != -1) return dp[index][target];

        int notPick = solve(index-1, target, nums,dp);
        int pick =0;
        if(nums[index] <= target) pick = solve(index-1, target-nums[index], nums,dp);

        return dp[index][target] = pick + notPick;
    }
    public static void main(String args[]){
        int[] nums = {1,2,2,3};
        int target = 3;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        System.out.println(solve(n-1, target , nums,dp));
        
    }
}


// Tabulation :TC->O(nxtarget) , SC->O(nxtarget) : dp array
class CountSubsetsWithSumk{
    public static void main(String args[]){
        int[] nums = {1,2,2,3};
        int target = 3;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        // base case : if(target == 0) return 1;
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
       //base case: if(index ==0)
        if(nums[0]<=target) dp[0][nums[0]] = 1 ;

        for(int index =1;index<n;index++){
            for(int tar = 1;tar<=target;tar++){
                int notPick = dp[index-1][tar];
                int pick  = 0;
                if(nums[index] <= tar) {
                    pick = dp[index-1][tar - nums[index]];
                }
                dp[index][tar] = pick + notPick;
            }
        }
        System.out.println(dp[n-1][target]);
    }
}


// Tabulation with space optimization :TC->O(nxtarget) , SC->O(target) : extra arrays
class CountSubsetsWithSumk{
    public static void main(String args[]){
        int[] nums = {1,2,2,3};
        int target = 3;
        int n = nums.length;
        int[] prev =  new int[target+1];
        int[] cur =  new int[target+1];

        prev[0] = cur[0] = 1;
        if(nums[0]<=target) prev[nums[0]] = 1 ;
        for(int index =1;index<n;index++){
            for(int tar = 1;tar<=target;tar++){
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
        System.out.println(prev[target]);
    }
}

// ==================================================== If array has zeros===========================================================================

// Recursion :TC->O(2^n) , SC->O(n) : recursion stack space
class check{
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
    public static void main(String args[]){
        int[] nums = {0,0,1};
        int target = 1;
        int n = nums.length;
        System.out.println(solve(n-1, target , nums));
    }
}

// Memoization :TC->O(nxtarget) , SC->O(n) : recursion stack space +O(nxtarget) : dp array
class check{
    static int solve(int index, int target , int[] nums, int[][] dp){
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
    public static void main(String args[]){
        int[] nums = {0,0,1};
        int target = 1;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        System.out.println(solve(n-1, target , nums,dp));
        
    }
}


// Tabulation :TC->O(nxtarget) , SC->O(nxtarget) : dp array
class check{
    public static void main(String args[]){
        int[] nums = {0,0,1};
        int target = 1;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
    
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
        System.out.println(dp[n-1][target]);
    }
}


// Tabulation with space optimization :TC->O(nxtarget) , SC->O(target) : extra arrays
class check{
    public static void main(String args[]){
        int[] nums = {0,0,1};
        int target = 1;
        int n = nums.length;
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
        System.out.println(prev[target]);
    }
}

