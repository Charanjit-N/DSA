// Recursion 
// TC-> >>O(2^n) : greater than 2^n as we are standing at same index for pick it again and again
// SC -> O(amount) :recursion stack space worst case if we have denomination 1 => amount/1= amount

class Solution {
    int solve(int index, int amt, int[] coins){
        if(index==0){
            if(amt % coins[0] ==0 ) return amt/coins[0];
            return (int)1e9;
        }
        int notPick =  0 + solve(index-1, amt, coins);
        int pick = (int)1e9;
        if(coins[index] <= amt) pick =  1 + solve(index, amt-coins[index],coins);
        return Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = solve(n-1,amount,coins);
        return ans >= (int)1e9 ? -1 : ans;
    }
}


//Memoization
// TC->O(n x targtet)
// SC->O(amount) : recursion stack space + O(n x amount):dp array
class Solution {
    int solve(int index, int amt, int[] coins,int[][] dp){
        if(index==0){
            if(amt % coins[0] ==0 ) return amt/coins[0];
            return (int)1e9;
        }
        if(dp[index][amt]!=-1) return dp[index][amt];
        int notPick =  0 + solve(index-1, amt, coins,dp);
        int pick = (int)1e9;
        if(coins[index] <= amt){
            pick =  1 + solve(index, amt-coins[index],coins,dp);
        }
        return dp[index][amt] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans = solve(n-1,amount,coins,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}


// Tabulation  : TC->O(n x amount), SC->O(n x amount) : dp array
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt % coins[0]==0) dp[0][amt] =  amt/coins[0];
            else dp[0][amt] = (int)1e9;
        }
        for(int index =1;index<n;index++){
            for(int amt=0;amt<=amount;amt++){
                int notPick =  0 + dp[index-1][amt] ;
                int pick = (int)1e9;
                if(coins[index] <= amt){
                    pick =  1 + dp[index][amt-coins[index]];
                }
                dp[index][amt] =  Math.min(pick, notPick);
            }   
        }
        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount];
    }
}

// Tabulation with space optimization : TC->O(n x amount) , SC->O(amount) : extra arrays
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev= new int[amount+1];
        int[] cur = new int[amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt % coins[0]==0) prev[amt] =  amt/coins[0];
            else prev[amt] = (int)1e9;
        }
        for(int index =1;index<n;index++){
            for(int amt=0;amt<=amount;amt++){
                int notPick =  0 + prev[amt] ;
                int pick = (int)1e9;
                if(coins[index] <= amt){
                    pick =  1 + cur[amt-coins[index]];
                }
                cur[amt] =  Math.min(pick, notPick);
            }
            for(int amt = 0;amt<=amount;amt++){
                prev[amt]  = cur[amt];
            }
        }
        return prev[amount] >= (int)1e9 ? -1 : prev[amount];
    }
}