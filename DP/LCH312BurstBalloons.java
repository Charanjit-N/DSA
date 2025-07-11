
// Recursion   : TC->O(Exponential), SC->O(n) : recursion stack space.
class Solution {
    int solve(int i , int j, int[] balloons){
        if(i > j) return 0;
        int max = (int)-1e9;
        for(int k=i;k<=j;k++){
            int coins = balloons[i-1]*balloons[k]*balloons[j+1] + 
            solve(i,k-1,balloons) +solve(k+1,j,balloons);
            max =  Math.max(max, coins);
        }
        return max;
    }
    public int maxCoins(int[] nums) {
        int n =  nums.length;
        int[]  balloons = new int[n+2];
        balloons[0] = balloons[n+1] =1;
        for(int i=0;i<n;i++){
            balloons[i+1] = nums[i];
        }
        return solve(1,n,balloons);
        
    }
}


// Memoization  : TC->O(n^3), SC->O(n^2) : dp array + O(n) : recursion stack space.
class Solution {
    int solve(int i , int j, int[] balloons,int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = (int)-1e9;
        for(int k=i;k<=j;k++){
            int coins = balloons[i-1]*balloons[k]*balloons[j+1] +    solve(i,k-1,balloons,dp) +solve(k+1,j,balloons,dp);
            max =  Math.max(max, coins);
        }
        return dp[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        int n =  nums.length;
        int[]  balloons = new int[n+2];
        balloons[0] = balloons[n+1] =1;
        for(int i=0;i<n;i++){
            balloons[i+1] = nums[i];
        }
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return solve(1,n,balloons,dp);
    }
}

// Tabulation  : TC->O(n^3), SC->O(n^2) : dp array.
class Solution {
    public int maxCoins(int[] nums) {
        int n =  nums.length;
        int[]  balloons = new int[n+2];
        balloons[0] = balloons[n+1] =1;
        for(int i=0;i<n;i++){
            balloons[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>=1;i--) {
            for(int j =1;j<=n;j++) {
                if(i > j) continue;  // base case
                int max = (int)-1e9;
                for(int k=i;k<=j;k++){
                    int coins = balloons[i-1]*balloons[k]*balloons[j+1] + dp[i][k-1]+dp[k+1][j];
                    max =  Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
        
    }
}