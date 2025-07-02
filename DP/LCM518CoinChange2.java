// Recursion 
// TC-> >>O(2^n) : greater than 2^n as we are standing at same index for pick it again and again
// SC -> O(amount) :recursion stack space worst case if we have denomination 1 => amount/1= amount
class Solution {
    int solve(int index, int amt, int[] coins){
        if(index==0){
            if(amt % coins[0] ==0 ) return 1;
            else return 0;
        }
        int notPick =  solve(index-1, amt, coins);
        int pick  = 0;
        if(coins[index] <= amt) pick =  solve(index, amt-coins[index],coins);
        return pick + notPick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return solve(n-1, amount, coins);
        
    }
}


//Memoization
// TC->O(n x targtet)
// SC->O(amount) : recursion stack space + O(n x amount):dp array
class Solution {
    int solve(int index, int amt, int[] coins,int[][] dp){
        if(index==0){
            if(amt % coins[0] ==0 ) return 1;
            else return 0;
        }
        if(dp[index][amt] != -1) return dp[index][amt];
        int notPick =  solve(index-1, amt, coins,dp);
        int pick  = 0;
        if(coins[index] <= amt) pick =  solve(index, amt-coins[index],coins,dp);
        return dp[index][amt] = pick + notPick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], -1);
        return solve(n-1, amount, coins,dp);
        
    }
}

// Tabulation  : TC->O(n x amount), SC->O(n x amount) : dp array
class Solution {
  
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt % coins[0] == 0) dp[0][amt]= 1;
        }

        for(int index=1;index<n;index++){
            for(int amt=0;amt<=amount;amt++){
                int notPick =  dp[index-1][amt];
                int pick  = 0;
                if(coins[index] <= amt) pick =  dp[index][amt-coins[index]];
                dp[index][amt] = pick + notPick;
            }
        }
        return dp[n-1][amount];
    }
}


// Tabulation with space optimization : TC->O(n x amount) , SC->O(amount) : extra arrays
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt % coins[0] == 0) prev[amt]= 1;
        }
        for(int index=1;index<n;index++){
            for(int amt=0;amt<=amount;amt++){
                int notPick =  prev[amt];
                int pick  = 0;
                if(coins[index] <= amt) pick =  cur[amt-coins[index]];
                cur[amt] = pick + notPick;
            }

            for(int amt =0 ;amt<=amount;amt++){
                prev[amt] =  cur[amt];
            }
        }
        return prev[amount];
    }
}