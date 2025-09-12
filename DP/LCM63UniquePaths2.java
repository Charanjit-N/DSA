// Recursion
// TC ->O(2^(mxn)) : We have mxn cell/states in our recursion and ofr each we have two paths either down or right 
// SC- -> O(path length) = O( (m-1)  + (n-1) ) : recursion stack space
class Solution {

    int solve(int row, int col, int[][] obstacleGrid){
        if(row >=0  && col >=0 && obstacleGrid[row][col] == 1) return 0;
        if(row ==0 && col ==0) return 1;
        if(row < 0 || col < 0) return 0; 
        int up = solve(row-1, col, obstacleGrid);
        int left = solve(row, col-1,obstacleGrid);
        return up +  left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=  obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return solve(m-1,n-1,obstacleGrid);
        
    }
}

// Memoization 
// TC -> O(m x n) : We can have at max these many recursion calls
// SC- -> O(path length/recursion stack space) + O(dp array) = O( (m-1)  + (n-1)) + O((m x n) ) 
class Solution {

    int solve(int row, int col, int[][] obstacleGrid, int[][] dp){
        if(row >=0  && col >=0 && obstacleGrid[row][col] == 1) return 0;
        if(row ==0 && col ==0) return 1;
        if(row < 0 || col < 0) return 0; 

        if(dp[row][col] != -1) return dp[row][col];
        int up = solve(row-1, col, obstacleGrid,dp);
        int left = solve(row, col-1,obstacleGrid,dp);
        return dp[row][col] = up +  left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=  obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(m-1,n-1,obstacleGrid,dp);
        
    }
}



// TC->O(m x n), SC -> O(m x n)
// tabulation 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=  obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp  =  new int[m][n];
        // dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i==0 && j==0) dp[i][j] = 1;
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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=  obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev   =  new int[n];
        // dp[0][0] = 1;
        for(int i=0;i<m;i++){
            int[] cur = new int[n];
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1) cur[j] = 0;
                else if(i==0 && j==0) cur[j] = 1;
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