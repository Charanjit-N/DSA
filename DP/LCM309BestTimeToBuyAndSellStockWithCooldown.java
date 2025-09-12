// Recursion : TC->O(2^n) , SC->O(n) : recursion stack space.
class Solution {
    int solve(int index, int buy, int[] prices){
        if(index >= prices.length) return 0;
        if(buy == 1){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,0,prices);
            int notPick  = 0 + solve(index+1 ,1,prices);
            return Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+2,1,prices);
            int notSell = 0 + solve(index+1,0,prices); 
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        return solve(0,1,prices);
    }
}

// Memoization : TC->O(nx2) , SC->O(nx2):dp array + O(n) : recursion stack space.
class Solution {
    int solve(int index, int buy, int[] prices,int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,0,prices,dp);
            int notPick  = 0 + solve(index+1 ,1,prices,dp);
            return dp[index][buy] = Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+2,1,prices,dp);
            int notSell = 0 + solve(index+1,0,prices,dp); 
            return dp[index][buy] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(0,1,prices,dp);
    }
}


// Tabulation : TC->O(nx2) , SC->O(nx2):dp array.
class Solution {   
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int index = n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 1){  // we can buy or skip
                    int pick =  -prices[index] + dp[index+1][0];
                    int notPick  = 0 + dp[index+1][1];
                    dp[index][buy] = Math.max(pick , notPick);
                }
                else{    // we can sell or skip
                    int sell = + prices[index] + dp[index+2][1];
                    int notSell = 0 + dp[index+1][0]; 
                    dp[index][buy] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }
}


// Tabulation with space optimization: TC->O(n) , SC->O(1): 3 1x2 arrays.
class Solution {   
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next2 = new int[2];
        int[] next1 = new int[2];
        int[] cur = new int[2];
        for(int index = n-1;index>=0;index--){
            // we can buy or skip
            int pick =  -prices[index] + next1[0];
            int notPick  = 0 + next1[1];
            cur[1] = Math.max(pick , notPick);

            // we can sell or skip
            int sell = + prices[index] + next2[1];
            int notSell = 0 + next1[0]; 
            cur[0] = Math.max(sell, notSell);

            for(int x = 0;x<2;x++){
                next2[x] = next1[x];
                next1[x] =  cur[x];
            }
        }
        return next1[1]; // return cur[1];
    }
}