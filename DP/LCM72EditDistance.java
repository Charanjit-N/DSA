// Recursion : TC-> Exponential (3 powers) , SC->O(m+n) : recursion stack space
class Solution {
    int solve(int i, int j , String word1, String word2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(word1.charAt(i) == word2.charAt(j)){
            return solve(i-1,j-1,word1,word2);
        }
        
        int insert =  solve(i,j-1,word1,word2);
        int delete =  solve(i-1,j,word1,word2);
        int replace = solve(i-1,j-1,word1,word2);
        return  1 + Math.min(insert, Math.min(delete , replace));
        
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return solve(m-1,n-1,word1,word2);
    }
}

// Memoization : TC->O(mxn) , SC->O(mxn) : dp array + O(m+n) : recursion stack space
class Solution {
     int solve(int i, int j , String word1, String word2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1 ) return dp[i][j];
        
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(i-1,j-1,word1,word2,dp);
        }
        
        int insert =  solve(i,j-1,word1,word2,dp);
        int delete =  solve(i-1,j,word1,word2,dp);
        int replace =  solve(i-1,j-1,word1,word2,dp);
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete , replace));
        
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return solve(m-1,n-1,word1,word2,dp);
    }
}


class Solution {
     int solve(int i, int j , String word1, String word2,int[][] dp){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j] != -1 ) return dp[i][j];
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            return dp[i][j] = solve(i-1,j-1,word1,word2,dp);
        }
        int insert =  solve(i,j-1,word1,word2,dp);
        int delete =  solve(i-1,j,word1,word2,dp);
        int replace =  solve(i-1,j-1,word1,word2,dp);
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete , replace));
        
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);
        return solve(m,n,word1,word2,dp);
    }
}



// Tabulation : TC->O(mxn) , SC->O(mxn) : dp array 
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int j=0;j<=n;j++) dp[0][j] = j;
        for(int i=0;i<=m;i++) dp[i][0] = i;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int delete =  dp[i-1][j];
                    int replace =  dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete , replace));
                }
            }
        }
        return dp[m][n];
    }
}


// Tabulation with space optimization: TC->O(mxn) , SC->O(n) : extra array 
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n+1];
        int[] cur = new int[n+1];
        for(int j=0;j<=n;j++) prev[j] = j;
     
        for(int i=1;i<=m;i++){
            cur[0] = i;
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cur[j] = prev[j-1];
                }
                else{
                    int insert = cur[j-1];
                    int delete =  prev[j];
                    int replace = prev[j-1];
                    cur[j] = 1 + Math.min(insert, Math.min(delete , replace));
                }
            }
            for(int j=0;j<=n;j++){
                prev[j] =  cur[j];
            }
        }
        return prev[n];
    }
}