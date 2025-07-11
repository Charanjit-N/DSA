/* Given an array and a target return true if there exist a subset of an array who sum = target
*/


// ----------------------------------------------------------------- Approach 1--------------------------------------------------


// Recursion :  TC->O(2^n), SC->O(n) recursion stack space
class SubsetSumEqualtoK{
    static boolean solve(int index,  int target , int[] nums){
       if(target == 0) return true;
       if(index ==0) return nums[index] == target;

       boolean notPick = solve(index-1, target , nums);
       boolean pick  = false;
       if(nums[index] <= target)   pick = solve(index-1, target - nums[index] , nums);
       return pick || notPick;
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        int target  = 11;
        System.out.println(solve(nums.length-1,target, nums));
    }
    
}

// Memoization :  TC->O(n x target), SC->O(n) recursion stack space + o(n x target) : dp array
class SubsetSumEqualtoK{
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
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        int target  =4;
        int n= nums.length;
        int[][] dp =  new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        System.out.println(solve(n-1,target, nums,dp));
    }
}

// Tabulation :  TC->O(n x target), SC-> o(n x target) : dp array
class SubsetSumEqualtoK{
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        int target  =4;   
        int n= nums.length;
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
        System.out.println(dp[n-1][target]);
    }
}

// Tabulation with space optimization:  TC->O(n x target), SC-> o(target) : extra arrays
class SubsetSumEqualtoK{
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        int target  =4;   
        int n= nums.length;
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
        System.out.println(prev[target]);
    }
}





// ----------------------------------------------------------------- Approach 2--------------------------------------------------
// Recursion
class SubsetSumEqualtoK{
    static boolean solve(int index, int sum,  int target , int[] nums){
       if(index ==nums.length) return sum == target;
       if(sum == target ) return true;
       boolean notPick = solve(index+1, sum, target , nums);
       boolean pick = false;
       if(sum+nums[index] <= target){
        pick = solve(index+1, sum+nums[index], target , nums);
       }
       return pick || notPick;
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        int target  = 4;
        System.out.println(solve(0,0,target, nums));
    }
    
}

// Memoization :  TC->O(n x target), SC->O(n) recursion stack space + o(n x target) : dp array
class SubsetSumEqualtoK{
    static boolean solve(int index, int sum, int target , int[] nums,int[][] dp){
       if(index ==nums.length) return sum == target;
       if(sum == target ) return true;
       if(dp[index][target] != -1) return (dp[index][target]==1) ? true: false;
       boolean notPick = solve(index+1, sum, target , nums,dp);
       boolean pick = false;
       if(sum+nums[index] <= target){
        pick = solve(index+1, sum+nums[index], target , nums,dp);
       }
       dp[index][target] = (pick || notPick) ==true ? 1 : 0;
       return  pick || notPick;
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        int target  = 4;
        int n= nums.length;
        int[][] dp =  new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        System.out.println(solve(0,0,target, nums,dp));
    }
}


// Tabulation :  TC->O(nxtarget), SC->O(n x target) :dp array
class SubsetSumEqualtoK {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4};
        int target = 11;
        int n = nums.length;
        // dp[i][t] = true if a subset of elements from index i to n-1 can make sum target
        boolean[][] dp = new boolean[n + 1][target + 1];
        // Base Case: sum == target at the end (i.e., dp[n][target] = true)
        // Since we are starting from the end, base case is:
        for (int i = 0; i <= n; i++) {
            dp[i][target] = true;  // target already met → true
        }
        // Fill the table in reverse (bottom-up)
        for (int index = n - 1; index >= 0; index--) {
            for (int sum = target; sum >= 0; sum--) {
                boolean notPick = dp[index + 1][sum];
                boolean pick = false;
                if (sum + nums[index] <= target) {
                    pick = dp[index + 1][sum + nums[index]];
                }
                dp[index][sum] = pick || notPick;
            }
        }
        // Our answer starts from index 0 with sum 0
       System.out.println(dp[0][0]);
        
    }
}

// Tabulation with space optimization :  TC->O(nxtarget), SC->O(target) :extra arrays
class SubsetSumEqualtoK {
    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4};
        int target = 4;
        boolean[] next = new boolean[target + 1];
        boolean[] cur = new boolean[target+1];
        next[target] = true;
        cur[target] = true;
        for (int index = n - 1; index >= 0; index--) {
            for (int sum = target; sum >= 0; sum--) {
                boolean notPick = next[sum];
                boolean pick = false;
                if (sum + nums[index] <= target) {
                    pick = next[sum + nums[index]];
                }
                cur[sum] = pick || notPick;
            }
            for(int x=0;x<=target;x++){
                next[x] = cur[x];
            }
        }
        System.out.println(next[0]);
    }
}