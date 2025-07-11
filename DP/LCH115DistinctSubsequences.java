// Recursion : TC->Exponential  >>O(2^m x 2^n)  , SC->O(m+n) : recursion stack space
class Solution {
    int solve(int i,int j , String s, String t){
        if(j<0) return 1;
        if(i<0) return 0;

        if(s.charAt(i) ==  t.charAt(j)){
            return solve(i-1,j-1,s,t) +  solve(i-1,j,s,t);
        }
        return solve(i-1,j,s,t);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        return solve(m-1,n-1,s,t);
        
    }
}

// Memoization : TC->O(mxn) , SC->O(mxn) : dp array + O(m+n) : recursion stack space
class Solution {
    int solve(int i,int j , String s, String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) ==  t.charAt(j)){
            return dp[i][j] = solve(i-1,j-1,s,t,dp) +  solve(i-1,j,s,t,dp);
        }
        return dp[i][j] = solve(i-1,j,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return solve(m-1,n-1,s,t,dp);
        
    }
}


class Solution {
    int solve(int i,int j , String s, String t,int[][] dp){
        if(j==0) return 1;
        if(i==0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i-1) ==  t.charAt(j-1)){
            return dp[i][j] = solve(i-1,j-1,s,t,dp) +  solve(i-1,j,s,t,dp);
        }
        return dp[i][j] = solve(i-1,j,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);
        return solve(m,n,s,t,dp);       
    }
}

// Tabulation : TC->O(mxn) , SC->O(mxn) : dp array 
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][0] = 1;
        for(int j=1;j<=n;j++) dp[0][j] = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) ==  t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{ 
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}

// Tabulation with space optimization with 2 arrays : TC->O(mxn) , SC->O(2xn) : extra arrays
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        prev[0] = 1; cur[0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) ==  t.charAt(j-1)){
                    cur[j] = prev[j-1] + prev[j];
                }
                else{ 
                    cur[j] = prev[j];
                }
            }
            for(int j=0;j<=n;j++){
                prev[j] = cur[j];
            }
        }
        return prev[n];
    }
}

// Tabulation with space optimization with 1 array1 : TC->O(mxn) , SC->O(n) : extra array
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n+1];
        prev[0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=n;j>=1;j--){
                if(s.charAt(i-1) ==  t.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
                // else{ 
                //     prev[j] = prev[j];
                // }
            }
        }
        return prev[n];
    }
}