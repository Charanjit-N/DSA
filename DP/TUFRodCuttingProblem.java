

/*
Given a rod of length N inches and an array price[] where price[i] denotes the value of a piece of rod of length i inches (1-based indexing). Determine the maximum value obtainable by cutting up the rod and selling the pieces. Make any number of cuts, or none at all, and sell the resulting pieces.
*/

// Recursion :  TC-> >> O(2^n) as we are taking same index multiple times, SC-> O(rodLength):recursion stack space
class TUFRodCuttingProblem{
    static int solve(int index, int rodLength,int[] price){
        if(index==0){
            return rodLength * price[0];
        }
        int notPick =  0 + solve(index-1,rodLength,price);
        int pick = (int)-1e9;
        if(index+1 <= rodLength){
            pick = price[index] + solve(index, rodLength-(index+1),price);
        }
        return Math.max(pick, notPick);

    }
    public static void main(String args[]){
        int[] price = {1,6,8,9,10,19,7,20};
        int rodLength  = 8; // price.length
        
        int n = price.length;
        System.out.println(solve(n-1,n,price));
    }
}

//Memoization :  TC->O(n x rodLength) = O(n x n), SC->O(rodLength):recursion stack space + O(n x rodLength) : dp array
class TUFRodCuttingProblem{
    static int solve(int index, int rodLength,int[] price,int[][] dp){
        if(index==0){
            return rodLength * price[0];
        }
        if(dp[index][rodLength] != -1) return dp[index][rodLength];
        int notPick =  0 + solve(index-1,rodLength,price,dp);
        int pick = (int)-1e9;
        if(index+1 <= rodLength){
            pick = price[index] + solve(index, rodLength-(index+1),price,dp);
        }
        return dp[index][rodLength] = Math.max(pick, notPick);

    }
    public static void main(String args[]){
        int[] price = {1,6,8,9,10,19,7,20};
        int rodLength  = 8; // price.length
        int n = price.length;
        int[][] dp = new int[n][rodLength+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        System.out.println(solve(n-1,n,price,dp));
    }
}


//Tabulation :  TC->O(n x rodLength) = o(n x n), SC->O(n x rodLength) : dp array
class TUFRodCuttingProblem{
    public static void main(String args[]){
        int[] price = {1,6,8,9,10,19,7,20};
        int rodLength  = 8; // price.length
        
        int n = price.length;

        int[][] dp = new int[n][rodLength+1];
        for(int rl = 0;rl <=n;rl++){
            dp[0][rl] = rl*price[0];
        }

        for(int index=1;index<n;index++){
            for(int rl = 0;rl<=n;rl++){
                int notPick =  0 + dp[index-1][rl];
                int pick = (int)-1e9;
                if(index+1 <= rl){
                    pick = price[index] + dp[index][rl-(index+1)];
                }
                dp[index][rl] = Math.max(pick, notPick);

            }
        }
        System.out.println(dp[n-1][n]);
    }
}



//Tabulation with space optimization (2 arrays) :  TC->O(n x rodLength) = O(n x n), SC->O(2 * rodLength) : extra arrays
class TUFRodCuttingProblem{
    public static void main(String args[]){
        int[] price = {1,6,8,9,10,19,7,20};
        int rodLength  = 8; // price.length
        int n = price.length;
        int[] prev = new int[rodLength+1];
        int[] cur = new int[rodLength+1];
        for(int rl = 0;rl <=n;rl++){
            prev[rl] = rl*price[0];
        }
        for(int index=1;index<n;index++){
            for(int rl = 0;rl<=n;rl++){
                int notPick =  0 + prev[rl];
                int pick = (int)-1e9;
                if(index+1 <= rl){
                    pick = price[index] + cur[rl-(index+1)];
                }
                cur[rl] = Math.max(pick, notPick);

            }
            for(int rl=0;rl<=n;rl++){
                prev[rl] =  cur[rl];
            }
        }
        System.out.println(prev[n]);
    }
}


//Tabulation with space optimization (1 array) :  TC->O(n x rodLength) = O(n x n), SC->O(rodLength) : extra array

class TUFRodCuttingProblem{
    public static void main(String args[]){
        int[] price = {1,6,8,9,10,19,7,20};
        int rodLength  = 8; // price.length
        int n = price.length;
        int[] prev = new int[rodLength+1];
        for(int rl = 0;rl <=n;rl++){
            prev[rl] = rl*price[0];
        }
        for(int index=1;index<n;index++){
            for(int rl = 0;rl<=n;rl++){
                int notPick =  0 + prev[rl];
                int pick = (int)-1e9;
                if(index+1 <= rl){
                    pick = price[index] + prev[rl-(index+1)];
                }
                prev[rl] = Math.max(pick, notPick);
            }
        }
        System.out.println(prev[n]);
    }
}