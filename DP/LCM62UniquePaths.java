// Recursion  
// TC ->O(2^(mxn)) : We have mxn cell/states in our recursion and ofr each we have two paths either down or right 
// SC- -> O(path length) = O( (m-1)  + (n-1) ) : recursion stack space
class Solution {
    int solve(int row, int col,int m, int n){
        if(row ==m-1 && col ==n-1){
            return 1;
        }
        int down = 0, right =0;
        if(row < m-1)  down = solve(row+1, col, m, n);
        if(col < n-1) right = solve(row, col+1, m , n);
        return down + right;
    }
    public int uniquePaths(int m, int n) {
        return solve(0,0,m,n);
    }
}

// Recursion 
class Solution {
    int solve(int row, int col){
        if(row == 0 && col ==0) return 1;
        
        if(row <0 || col <0) return 0;
        
        int up = solve(row-1, col);
        int  left = solve(row, col-1);
        return up + left;
    }
    public int uniquePaths(int m, int n) {
        return solve(m-1,n-1);
    }
}





// TC -> O(m x n) : We can have at max these many recursion calls
// SC- -> O(path length/recursion stack space) + O(dp array) = O( (m-1)  + (n-1)) + O((m x n) ) 
// Memoization
class Solution {
    int solve(int row, int col,int m, int n, int[][] dp){
        if(row ==m-1 && col ==n-1){
            return 1;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int down = 0, right =0;
        if(row < m-1)  down = solve(row+1, col, m, n,dp);
        if(col < n-1) right = solve(row, col+1, m , n,dp);
        return dp[row][col] = down + right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp  =  new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,m,n,dp);
    }
}


// Memoization
class Solution {
    int solve(int row, int col, int[][] dp){
        if(row == 0 && col ==0) return 1;
        
        if(row <0 || col <0) return 0;

        if(dp[row][col] != -1) return dp[row][col];
        
        int up = solve(row-1, col, dp);
        int  left = solve(row, col-1, dp);

        return dp[row][col] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1,n-1, dp);
    }
}


// TC->O(m x n), SC -> O(m x n)
// tabulation 
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp  =  new int[m][n];
       
        for(int x=0;x<n;x++){
            dp[m-1][x] = 1;
        }
        for(int x = 0;x<m;x++){
            dp[x][n-1] = 1;
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int down  = dp[i+1][j];
                int right  = dp[i][j+1];
                dp[i][j] =  down + right;
            }
        }
        return dp[0][0];
    }
}

// tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp  =  new int[m][n];
        // dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int up = 0, left=0;
                    if(i-1 >= 0) up  = dp[i-1][j];
                    if(j-1 >=0)  left  = dp[i][j-1];
                    dp[i][j] =  up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// TC->O(m x n), SC -> O(n)
// tabulation with space optimization
class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev  =  new int[n];
        
        for(int x=0;x<n;x++){
            prev[x] = 1;
        }
        
        for(int i=m-2;i>=0;i--){
            int right  = 1;
            for(int j=n-2;j>=0;j--){
                int d  = prev[j];
                int r  = right;
                prev[j] =  d + r;
                right  =  prev[j];
            }
        }
        return prev[0];
    }
}

// tabulation with space optimization
class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev   =  new int[n];
        // dp[0][0] = 1;
        for(int i=0;i<m;i++){
            int[] cur = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) cur[j] = 1;
                else{
                    int up = 0, left=0;
                    if(i-1 >= 0) up  = prev[j];
                    if(j-1 >=0)  left  = cur[j-1];
                    cur[j] =  up + left;
                }
            }

            for(int j=0;j<n;j++){
                prev[j] =  cur[j];
            }
        }
        return prev[n-1];
    }
}