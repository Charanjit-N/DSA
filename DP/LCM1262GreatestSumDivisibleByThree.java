// Tabulation : TC->O(3*n) = O(n)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
        // dp[n][0] = 0, dp[n][1] = dp[n][2] = -inf
        Arrays.fill(dp[n], -1000000000);
        dp[n][0] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int mod = nums[i] % 3;
            for (int rem = 0; rem < 3; rem++) {
                // not pick
                int notPick = dp[i + 1][rem];
                // pick
                int oldRem = (rem - mod + 3) % 3;
                int pick = nums[i] + dp[i + 1][oldRem];
                dp[i][rem] = Math.max(pick, notPick);
            }
        }
        return dp[0][0];
    }
}

//  Memoization : O(3*n) = O(n)
class Solution {
    int solve(int[] nums, int index, int rem, int[][] dp){
        if(index == nums.length){
            return (rem == 0) ? 0 : Integer.MIN_VALUE ;
        }
        if(dp[index][rem] != -1) return dp[index][rem];
        // pick number
        int newRem = (rem + nums[index]) % 3;
        int pick = nums[index] + solve(nums, index+1,newRem,dp);
        // not choose number
        int notPick = solve(nums, index+1, rem,dp);
        return dp[index][rem] = Math.max(pick, notPick);
    }
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,0,dp);
    }
}

// Recursion : O(2^n)
class Solution {
    int solve(int[] nums, int index, int rem){
        if(index == nums.length){
            return (rem == 0) ? 0 : Integer.MIN_VALUE ;
        }
        // pick number
        int newRem = (rem + nums[index]) % 3;
        int pick = nums[index] + solve(nums, index+1,newRem);
        // not pick
        int notPick = solve(nums, index+1, rem);
        return  Math.max(pick, notPick);
    }
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        return solve(nums,0,0); 
    }
}




// Greedy Approach + Math O(n)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int min_r1 = Integer.MAX_VALUE;
        int secondMin_r1 = Integer.MAX_VALUE;
        int min_r2 = Integer.MAX_VALUE;
        int secondMin_r2 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num = nums[i];
            totalSum += num;
            if((num % 3) == 1){
                if(num <= min_r1) {
                    secondMin_r1 = min_r1;
                    min_r1 = num;
                }
                else if(num > min_r1 &&  num < secondMin_r1 ) {
                    secondMin_r1 = num;
                }
            }
            if((num % 3) == 2){
                if(num <= min_r2) {
                    secondMin_r2 = min_r2;
                    min_r2 = num;
                }
                else if(num > min_r2 &&  num < secondMin_r2 ) {
                    secondMin_r2 = num;
                }
            }
        }
        
        int remove = Integer.MAX_VALUE;
        if((totalSum % 3) == 0) return totalSum;
        else if((totalSum % 3) ==1){
            remove = Math.min(remove, min_r1);
            if(min_r2 != Integer.MAX_VALUE && secondMin_r2 != Integer.MAX_VALUE){
                remove = Math.min(remove , min_r2 + secondMin_r2);
            }
        }else{  // if totalSum % 3 ==2
            remove = Math.min(remove, min_r2);
            if(min_r1 != Integer.MAX_VALUE && secondMin_r1 != Integer.MAX_VALUE){
                remove = Math.min(remove , min_r1 + secondMin_r1);
            }
        }

        return (remove != Integer.MAX_VALUE) ? totalSum - remove : 0;
        
    }
}