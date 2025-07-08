// Recursion : TC->O(2^n) , SC->O(n) : recursion stack space.
class Solution {
    int solve(int index, int buy, int[] prices,int fee){
        if(index == prices.length) return 0;
        if(buy == 1){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,0,prices,fee);
            int notPick  = 0 + solve(index+1 ,1,prices,fee);
            return Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] - fee + solve(index+1,1,prices,fee);
            int notSell = 0 + solve(index+1,0,prices,fee); 
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices,int fee) {
        return solve(0,1,prices,fee);
    }
}


// Memoization : TC->O(nx2) , SC->O(nx2):dp array + O(n) : recursion stack space.
class Solution {
    int solve(int index, int buy, int[] prices,int fee,int[][] dp){
        if(index == prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1){  // we can buy or skip
            int pick =  -prices[index] - fee + solve(index+1,0,prices,fee,dp);
            int notPick  = 0 + solve(index+1 ,1,prices,fee,dp);
            return dp[index][buy] = Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index]  + solve(index+1,1,prices,fee,dp);
            int notSell = 0 + solve(index+1,0,prices,fee,dp); 
            return dp[index][buy] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(0,1,prices,fee,dp);
    }
}


// Tabulation : TC->O(nx2) , SC->O(nx2):dp array.
class Solution {   
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int index = n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 1){  // we can buy or skip
                    int pick =  -prices[index] + dp[index+1][0];
                    int notPick  = 0 + dp[index+1][1];
                    dp[index][buy] = Math.max(pick , notPick);
                }
                else{    // we can sell or skip
                    int sell = + prices[index] - fee + dp[index+1][1];
                    int notSell = 0 + dp[index+1][0]; 
                    dp[index][buy] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }
}



// Tabulation with space optimization : TC->O(nx2) , SC->O(1): 2 (1x2) arrays.
class Solution {   
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int[] next = new int[2];
        int[] cur = new int[2];
        next[0] = 0; 
        next[1] = 0;
        for(int index = n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 1){  // we can buy or skip
                    int pick =  -prices[index] + next[0];
                    int notPick  = 0 + next[1];
                    cur[buy] = Math.max(pick , notPick);
                }
                else{    // we can sell or skip
                    int sell = + prices[index] - fee  + next[1];
                    int notSell = 0 + next[0]; 
                    cur[buy] = Math.max(sell, notSell);
                }
            }
            next[0] =  cur[0];
            next[1] = cur[1];
        }
        return next[1];
    }
}
