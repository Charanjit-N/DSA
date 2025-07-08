// Recursion : TC->O(2^n) , SC->O(n) : recursion stack space.
class Solution {
    int solve(int index, int buy, int cap, int[] prices){
        if(cap == 0) return 0;
        if(index == prices.length) return 0;

        if(buy == 1){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,0,cap,prices);
            int notPick  = 0 + solve(index+1 ,1,cap,prices);
            return Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+1,1,cap-1,prices);
            int notSell = 0 + solve(index+1,0,cap,prices); 
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int cap = 2;
        return solve(0,1,cap,prices); 
    }
}

// Memoization : TC->O(nx2x3) , SC->O(nx2x3):dp array + O(n) : recursion stack space.
class Solution {
    int solve(int index, int buy, int cap,int[] prices,int[][][] dp){
        if(cap==0) return 0;
        if(index == prices.length) return 0;
        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        if(buy == 1){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,0,cap,prices,dp);
            int notPick  = 0 + solve(index+1 ,1,cap,prices,dp);
            return dp[index][buy][cap] = Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+1,1,cap-1,prices,dp);
            int notSell = 0 + solve(index+1,0,cap,prices,dp); 
            return dp[index][buy][cap] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for( int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }   
        int cap =2;
        return solve(0,1,cap,prices,dp);
    }
}


// Tabulation  : TC->O(nx2x3) , SC->O(nx2x3):dp array
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int index=0;index<=n;index++){
            for( int buy=0;buy<=1;buy++){
                dp[index][buy][0] = 0;
            }
        }
        for(int buy =0;buy<=1;buy++){
            for(int cap=0;cap<=2;cap++){
                dp[n][buy][cap] = 0;
            }
        }
        for(int index=n-1;index>=0;index--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy == 1){  // we can buy or skip
                        int pick =  -prices[index] + dp[index+1][0][cap];
                        int notPick  = 0 + dp[index+1][1][cap];
                        dp[index][buy][cap] = Math.max(pick , notPick);
                    }
                    else{    // we can sell or skip
                        int sell = + prices[index] + dp[index+1][1][cap-1];
                        int notSell = 0 + dp[index+1][0][cap]; 
                        dp[index][buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}


// Tabulation with space optimization : TC->O(nx2x3) , SC->O(1): 2x3 arrays.
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];
        int[][] cur = new int[2][3];
        for(int index=n-1;index>=0;index--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy == 1){  // we can buy or skip
                        int pick =  -prices[index] + next[0][cap];
                        int notPick  = 0 + next[1][cap];
                        cur[buy][cap] = Math.max(pick , notPick);
                    }
                    else{    // we can sell or skip
                        int sell = + prices[index] + next[1][cap-1];
                        int notSell = 0 + next[0][cap]; 
                        cur[buy][cap] = Math.max(sell, notSell);
                    }
                }
            }
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    next[buy][cap] = cur[buy][cap];
                }
            }
        }
        return next[1][2];
    }
}

//Other approach  Recursion using 2 states 
// TC->O(2^n) , SC->O(n) : recursion stack space.

class Solution {
    int solve(int index, int transactions ,int[] prices){
        if(transactions == 4) return 0;
        if(index == prices.length) return 0;

        if(transactions % 2 == 0){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,transactions+1,prices);
            int notPick  = 0 + solve(index+1,transactions, prices);
            return Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+1,transactions+1,prices);
            int notSell = 0 + solve(index+1,transactions,prices); 
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        return solve(0,0,prices);   
    }
}