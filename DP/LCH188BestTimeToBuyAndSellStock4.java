// Tabulation with space optimization : TC->O(nx2xk) , SC->O(2xk): extra arrays.
class Solution {
    public int maxProfit(int k , int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][k+1];
        int[][] cur = new int[2][k+1];
        for(int index=n-1;index>=0;index--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
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
                for(int cap=1;cap<=k;cap++){
                    next[buy][cap] = cur[buy][cap];
                }
            }
        }
        return next[1][k];
    }
}


//Other approach  
// Recursion using 2 changing variables
// TC->O(2^n) , SC->O(n) : recursion stack space.
class Solution {
    int solve(int index, int tranNo, int k, int[] prices){
        if(tranNo == 2*k) return 0;
        if(index == prices.length) return 0;

        if(tranNo % 2 == 0){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,tranNo+1,k,prices);
            int notPick  = 0 + solve(index+1,tranNo, k,prices);
            return Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+1,tranNo+1,k,prices);
            int notSell = 0 + solve(index+1,tranNo,k,prices); 
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int k, int[] prices) {
        return solve(0,0,k,prices);   
    }
}



// Memoization : TC->O(n x 2k) , SC->O(n x 2k):dp array + O(n) : recursion stack space.
class Solution {
    int solve(int index, int tranNo, int k, int[] prices,int[][] dp){
        if(tranNo == 2*k || index == prices.length) return 0;
        if(dp[index][tranNo] != -1) return dp[index][tranNo];
        if(tranNo % 2 == 0){  // we can buy or skip
            int pick =  -prices[index] + solve(index+1,tranNo+1,k,prices,dp);
            int notPick  = 0 + solve(index+1,tranNo, k,prices,dp);
            return dp[index][tranNo] = Math.max(pick , notPick);
        }
        else{    // we can sell or skip
            int sell = + prices[index] + solve(index+1,tranNo+1,k,prices,dp);
            int notSell = 0 + solve(index+1,tranNo,k,prices,dp); 
            return dp[index][tranNo] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,k,prices,dp);   
    }
}

// Tabulation : TC->O(n x 2k) , SC->O(n x 2k):dp array 
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int index=n-1;index>=0;index--){
            for(int tranNo = 2*k-1 ; tranNo>=0;tranNo--){
                 if(tranNo % 2 == 0){  // we can buy or skip
                    int pick =  -prices[index] + dp[index+1][tranNo+1];
                    int notPick  = 0 + dp[index+1][tranNo];
                    dp[index][tranNo] = Math.max(pick , notPick);
                }
                else{    // we can sell or skip
                    int sell = + prices[index] + dp[index+1][tranNo+1];
                    int notSell = 0 + dp[index+1][tranNo]; 
                    dp[index][tranNo] = Math.max(sell, notSell);
                }       
            }
        }
        return dp[0][0];   
    }
}


// Tabulation with space optimization: TC->O(n x 2k) , SC->O(2k): extra arrays
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] next = new int[2*k+1];
        int[] cur = new int[2*k+1];
        for(int index=n-1;index>=0;index--){
            for(int tranNo = 2*k-1 ; tranNo>=0;tranNo--){
                 if(tranNo % 2 == 0){  // we can buy or skip
                    int pick =  -prices[index] + next[tranNo+1];
                    int notPick  = 0 + next[tranNo];
                    cur[tranNo] = Math.max(pick , notPick);
                }
                else{    // we can sell or skip
                    int sell = + prices[index] + next[tranNo+1];
                    int notSell = 0 + next[tranNo]; 
                    cur[tranNo] = Math.max(sell, notSell);
                }       
            }
            for(int tranNo = 0 ; tranNo<2*k;tranNo++){
                next[tranNo] =  cur[tranNo];
            }
        }
        return next[0];   
    }
}