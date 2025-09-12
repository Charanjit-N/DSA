// Recursion :  TC>O(2 ^ (mxn)) , SC->O(path length = (m-1)+(n-1)) : recursion stack space
class Solution {
    int solve(int row, int col, int[][] grid){
        if(row == 0  && col == 0) return grid[0][0];
        if(row < 0  || col < 0) return Integer.MAX_VALUE;

        int up  = solve(row-1, col, grid);
        int left = solve(row, col-1, grid);
        return grid[row][col] + Math.min(up, left);

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(m-1,n-1,grid);
    }
}


// Memoization :  TC->O(mxn), SC->O(O(path length = (m-1)+(n-1) ): recursion stack space + O(mxn) : dp array 
class Solution {
    int solve(int row, int col, int[][] grid,int[][] dp){
        if(row == 0  && col == 0) return grid[0][0];
        if(row < 0  || col < 0) return Integer.MAX_VALUE;
        if(dp[row][col] != -1) return dp[row][col];
        int up  = solve(row-1, col, grid,dp);
        int left = solve(row, col-1, grid,dp);
        return grid[row][col] + Math.min(up, left);

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return solve(m-1,n-1,grid,dp);
    }
}


// Tabulation : TC->O(mxn) , SC->O(mxn)
class Solution {
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE, left  = Integer.MAX_VALUE;
                    if(i-1>=0) up  = grid[i][j] + dp[i-1][j];
                    if(j-1>=0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] =  Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// Tabulation with space optimization : TC->O(mxn) , SC->O(n) 

class Solution {
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] cur =  new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) cur[j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE, left  = Integer.MAX_VALUE;
                    if(i-1>=0) up  = grid[i][j] + prev[j];
                    if(j-1>=0) left = grid[i][j] + cur[j-1];
                    cur[j] =  Math.min(up, left);
                }
            }
            for(int j=0;j<n;j++){
                prev[j] =  cur[j];
            }
        }
        return prev[n-1];
    }
}

