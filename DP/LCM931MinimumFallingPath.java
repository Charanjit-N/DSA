// Recursion : 
class Solution {
    int solve(int row, int col, int m , int n ,int[][] matrix){
       if(row == m-1) return matrix[row][col];
        int leftDiag =  Integer.MAX_VALUE, rightDiag = Integer.MAX_VALUE;
        if(col-1>=0)  leftDiag = matrix[row][col] + solve(row+1, col-1, m,n,matrix);
        int down = matrix[row][col] + solve(row+1,col,m,n,matrix );
        if(col+1<n) rightDiag  = matrix[row][col] + solve(row+1,col+1,m,n,matrix);
        return Math.min(leftDiag, Math.min(down, rightDiag));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, solve(0, i, m, n , matrix));
        }
        return min;
    }
}

// Recursion : 
// TC ->O(n * 3^m) : For each of the n columns in the last row (row = m - 1), you call a recursive function with branching factor 3 and depth m
// SC->O(m) : path length/recursion stack space/ height of recursion tree
class Solution {
    int solve(int row, int col,int[][] matrix){
        if(col <0 || col >= matrix[0].length) return (int)1e9;
        if(row == 0) return matrix[0][col];

        int leftDiag = matrix[row][col] + solve(row-1, col-1,matrix);
        int Up = matrix[row][col] + solve(row-1,col,matrix );
        int rightDiag  = matrix[row][col] + solve(row-1,col+1,matrix);

        return Math.min(leftDiag, Math.min(Up, rightDiag));

    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, solve(m-1, i, matrix));
        }
        return min; 
    }
}

// Memoization: 
// TC ->O(mxn) : In the worst case, each cell (row, col) in the matrix is computed only once, because You store and reuse previously computed results via dp[row][col] != -1. There are m × n unique (row, col) combinations. Each call does a constant amount of work (3 recursive calls and a min operation), so: Time Complexity: O(m × n). At max, there will be M*N calls of recursion to solve a new problem
//SC->O(m): path length/recursion stack space/ height of recursion tree + O(mxn) : dp array 
class Solution {
    int solve(int row, int col, int[][] matrix,int[][] dp){
        if(col <0 || col >= matrix[0].length) return (int)1e9;
        if(row == 0) return matrix[0][col];
        if(dp[row][col] != -1) return dp[row][col];
        int leftDiag = matrix[row][col] + solve(row-1, col-1, matrix,dp);
        int Up = matrix[row][col] + solve(row-1,col, matrix ,dp);
        int rightDiag  = matrix[row][col] + solve(row-1,col+1, matrix,dp);
        return dp[row][col] = Math.min(leftDiag, Math.min(Up, rightDiag));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, solve(m-1, i, matrix,dp));
        }
        return min;  
    }
}

// Tabulation TC->O(mxn) , SC->O(mxn)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int leftDiag = (int)1e9, rightDiag = (int)1e9;
                if(j-1>=0) leftDiag = matrix[i][j] + dp[i-1][j-1];
                int up = matrix[i][j] + dp[i-1][j];
                if(j+1 < n) rightDiag = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.min(leftDiag, Math.min(up, rightDiag));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min = Math.min(min, dp[m-1][j]);
        }
        return min;
    }
}
// Tabulation with space optimization
// TC->O(mxn) , SC->O(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];
        for(int j=0;j<n;j++){
            prev[j] = matrix[0][j];
        }
        for(int i=1;i<m;i++){
            int[] cur = new int[n];
            for(int j=0;j<n;j++){
                int leftDiag = (int)1e9, rightDiag = (int)1e9;
                if(j-1>=0) leftDiag = matrix[i][j] + prev[j-1];
                int up = matrix[i][j] + prev[j];
                if(j+1 < n) rightDiag = matrix[i][j] + prev[j+1];
                cur[j] = Math.min(leftDiag, Math.min(up, rightDiag));
            }
            for(int j=0;j<n;j++){
                prev[j] = cur[j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min = Math.min(min, prev[j]);
        }
        return min;
    }
}