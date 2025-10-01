// Plain recursion : TC->O(3^n) , SC->O(n): recursion stack space
class Solution {
    int solve(int step, int n , int[] costs){
        if(step ==n) return 0;
        int min  = (int) 1e9;
        for(int j= step+1;j<=step+3 && j<= n;j++){
            int cost = costs[j-1]+((j-step)*(j-step)) + solve(j,n,costs);
            min = Math.min(min, cost);
        }
        return min;
    }
   
    public int climbStairs(int n, int[] costs) {
       return solve(0, n, costs);
            
    }
}


// Memoization : TC->O(3*n)=O(n) , SC->O(2*n): recursion stack space + dp array
class Solution {
    int solve(int step, int n , int[] costs, int[] dp){
        if(step ==n) return 0;
        if(dp[step] != -1) return dp[step];
        int min  = (int) 1e9;
        for(int j= step+1;j<=step+3 && j<= n;j++){
            int cost = costs[j-1]+((j-step)*(j-step)) + solve(j,n,costs,dp);
            min = Math.min(min, cost);
        }
        return dp[step] = min;
    }
   
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
       return solve(0, n, costs,dp);
            
    }
}


// Tabulation : TC->O(3*n)= O(n), SC->O(n): dp array
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int min = (int)1e9;
            for(int j = i+1;j<=i+3 && j<=n;j++){
                int cost = costs[j-1] +((j-i)*(j-i)) +  dp[j];
                min = Math.min(min , cost);
            }
            dp[i] = min;
        }
       return dp[0];  
    }
}


