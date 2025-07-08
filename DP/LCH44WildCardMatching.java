// Recursion : TC-> Exponential , SC->O(m+n) : recursion stack space
class Solution {
    boolean solve(int i, int j , String p, String s){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int ind=0;ind<=i;ind++){
                if(p.charAt(ind) != '*') return false;
            }
            return true;
        }
        if(p.charAt(i) == s.charAt(j)  || p.charAt(i)=='?'){
            return solve(i-1,j-1,p,s);
        }
        if(p.charAt(i) == '*'){
            return solve(i-1,j,p,s) || solve(i,j-1,p,s);
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        return solve(m-1, n-1, p, s);
    }
}


// Memoization : TC->O(mxn) , SC->O(mxn) : dp array + O(m+n) : recursion stack space
class Solution {
    boolean solve(int i, int j , String p, String s, int[][] dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int ind=0;ind<=i;ind++){
                if(p.charAt(ind) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j]==1 ? true : false;
        if(p.charAt(i) == s.charAt(j)  || p.charAt(i)=='?'){
            dp[i][j] =  solve(i-1,j-1,p,s,dp) ?  1 : 0;
            return  dp[i][j] == 1 ? true : false ;
        }
        if(p.charAt(i) == '*'){
            dp[i][j] = (solve(i-1,j,p,s,dp) || solve(i,j-1,p,s,dp)) ? 1 : 0;
            return  dp[i][j] == 1 ? true : false ;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i], -1);
        return solve(m-1, n-1, p, s,dp);
    }
}


class Solution {
    boolean solve(int i, int j , String p, String s, int[][] dp){
        if(i==0 && j==0) return true;
        if(i==0 && j>0) return false;
        if(j==0 && i>0){
            for(int ind=1;ind<=i;ind++){
                if(p.charAt(ind-1) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j]==1 ? true : false;
        if(p.charAt(i-1) == s.charAt(j-1)  || p.charAt(i-1)=='?'){
            dp[i][j] =  solve(i-1,j-1,p,s,dp) ?  1 : 0;
            return  dp[i][j] == 1 ? true : false ;
        }
        if(p.charAt(i-1) == '*'){
            dp[i][j] = (solve(i-1,j,p,s,dp) || solve(i,j-1,p,s,dp)) ? 1 : 0;
            return  dp[i][j] == 1 ? true : false ;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++) Arrays.fill(dp[i], -1);
        return solve(m, n, p, s,dp);
    }
}


// Tabulation : TC->O(mxn) , SC->O(mxn) : dp array 
class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=1;j<=n;j++) dp[0][j] = false;
        for(int i=1;i<=m;i++){
            boolean flag = true;
            for(int ind = 1;ind<=i;ind++){
                if(p.charAt(ind-1) != '*'){
                    flag =  false;
                    break;
                }
            }
            dp[i][0] = flag;
        }
        for(int i=1;i<=m;i++){
            for(int j= 1;j<=n;j++){
                if(p.charAt(i-1) == s.charAt(j-1)  || p.charAt(i-1)=='?'){
                    dp[i][j] =  dp[i-1][j-1];
                }
                else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j] =  false;
                }
            }
        }
        return dp[m][n];
    }
}

// Tabulation with space optimization: TC->O(mxn) , SC->O(n) : extra array 
class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[] prev = new boolean[n+1];
        boolean[] cur = new boolean[n+1];
        prev[0] = true;
        for(int j=1;j<=n;j++) prev[j] = false;
        for(int i=1;i<=m;i++){
            boolean flag = true;
            for(int ind = 1;ind<=i;ind++){
                if(p.charAt(ind-1) != '*'){
                    flag =  false;
                    break;
                }
            }
            cur[0] = flag;
            for(int j= 1;j<=n;j++){
                if(p.charAt(i-1) == s.charAt(j-1)  || p.charAt(i-1)=='?'){
                    cur[j] =  prev[j-1];
                }
                else if(p.charAt(i-1) == '*'){
                    cur[j] = prev[j] || cur[j-1];
                }
                else cur[j] =  false;
            }
            for(int j=0;j<=n;j++){
                prev[j] =  cur[j];
            }
        }
        return prev[n];
    }
}