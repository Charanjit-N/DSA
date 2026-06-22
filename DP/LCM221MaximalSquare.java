// ==================== dp (tabulation) : TC-->O(mxn), SC-->O(mxn) ====================================
//solve(r,c) -->get the max sqauare side with (r,c) as bottom right corner 
// dp[r][c] --> Max length of square with all ones with (r,c) a bottm right corner
class Solution {
    public int maximalSquare(char[][] matrix){
        int maxSideLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
       
        for(int row =0;row <m;row++){
            for(int col =0;col <n;col++){
                int up = (col -1 >= 0) ? dp[row][col-1] : 0;
                int left = (row-1 >=0) ? dp[row-1][col] : 0;
                int diag = (row-1 >= 0 && col-1 >=0) ? dp[row-1][col-1] : 0;
                if(matrix[row][col] == '1'){
                    dp[row][col] = 1 + Math.min(up ,Math.min(left, diag));
                    maxSideLen = Math.max(maxSideLen, dp[row][col]);
                }else{
                    dp[row][col] = 0;
                }
            }
        }
        return maxSideLen*maxSideLen ;
    }
}


//solve(r,c) -->get the max sqauare side with (r,c) as top left corner 
// dp[r][c] --> Max length of square with all ones with (r,c) a top left corner
class Solution {
    public int maximalSquare(char[][] matrix){
        int maxSideLen = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int row =m-1;row>=0;row--){
            for(int col =n-1;col>=0;col--){
                int down = (row+1 < m ) ? dp[row+1][col] : 0;
                int right = (col+1 < n) ? dp[row][col+1] : 0;
                int diag = (row+1 < m && col+1 < n) ? dp[row+1][col+1] : 0;
                if(matrix[row][col] == '1'){
                    dp[row][col] = 1 + Math.min(down ,Math.min(right, diag));
                    maxSideLen = Math.max(maxSideLen, dp[row][col]);
                }else{
                    dp[row][col] = 0;
                }
            }
        }
        return maxSideLen*maxSideLen ;
    }
}


//============================= dp (memoization) : TC --> O(mxn) , SC-->O(mxn)  ============================
/*
Longest path can move up or left (for botton right corner). Maximum depth ≈ m+n =>  Recursion stack= O(m+n)
SC=O(mxn)+O(m+n) = O(mxn)
*/
//solve(r,c) -->get the max sqauare side with (r,c) as bottom right corner 
// dp[r][c] --> Max length of square with all ones with (r,c) a bottm right corner
class Solution {
    int maxSideLen = 0;
    public int maximalSquare(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        solve(m-1,n-1,matrix,m,n,dp);
        return maxSideLen * maxSideLen ;
    }

    int solve(int row, int col, char[][] matrix, int m ,int n, int[][] dp){
        if(row < 0 || col < 0) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        int up = solve(row-1, col, matrix, m, n,dp);
        int left= solve(row, col-1, matrix, m, n,dp);
        int diag= solve(row-1, col-1, matrix, m, n,dp);
        if(matrix[row][col] == '1'){
            int sideLen = 1 + Math.min(up, Math.min(left, diag));
            maxSideLen = Math.max(maxSideLen , sideLen);
            return dp[row][col] = sideLen;
        }

        else return dp[row][col] = 0;
    }
}



//solve(r,c) -->get the max sqauare side with (r,c) as top left corner 
// dp[r][c] --> Max length of square with all ones with (r,c) as top left corner
class Solution {
    int maxSideLen = 0;
    public int maximalSquare(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        solve(0,0,matrix,m,n,dp);
        return maxSideLen * maxSideLen ;
    }

    int solve(int row, int col, char[][] matrix, int m ,int n, int[][] dp){
        if(row == m || col == n) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        int down = solve(row+1, col, matrix, m, n,dp);
        int right= solve(row, col+1, matrix, m, n,dp);
        int diag= solve(row+1, col+1, matrix, m, n,dp);
        if(matrix[row][col] == '1'){
            int sideLen = 1 + Math.min(down, Math.min(right, diag));
            maxSideLen = Math.max(maxSideLen , sideLen);
            return dp[row][col] = sideLen;
        }

        else return dp[row][col] = 0;
    }
}




//================================= Recursion TC-->O(mxn x 3^(m+n)) , SC-->O(mxn)=====================================
/*
Longest path can move up or left (for botton right corner). Maximum depth ≈ m+n =>  Recursion stack= O(m+n)
=> SC=O(m+n) 
*/
// solve(r,c) -->get the max sqauare side with (r,c) as bottom right corner 
class Solution {
    int maxSideLen = 0;
    public int maximalSquare(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int r =0 ; r < m ;r++){
            for(int c = 0; c < n;c++){
                solve(r,c,matrix,m,n);
            }
        }
        return maxSideLen * maxSideLen ;
    }
    int solve(int row, int col, char[][] matrix, int m ,int n){
        if(row < 0 || col < 0) return 0;
        int up = solve(row-1, col, matrix, m, n);
        int left= solve(row, col-1, matrix, m, n);
        int diag= solve(row-1, col-1, matrix, m, n);
        if(matrix[row][col] == '1'){
            int sideLen = 1 + Math.min(up, Math.min(left, diag));
            maxSideLen = Math.max(maxSideLen , sideLen);
            return sideLen;
        }
        else return 0;
    }
}



// solve(r,c) -->get the max sqauare side with (r,c) as top left corner 
class Solution {
    int maxSideLen = 0;
    public int maximalSquare(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int r =0 ; r < m ;r++){
            for(int c = 0; c < n;c++){
                solve(r,c,matrix,m,n);
            }
        }
        return maxSideLen * maxSideLen ;
    }
    int solve(int row, int col, char[][] matrix, int m ,int n){
        if(row == m || col == n) return 0;
        int bottom = solve(row+1, col, matrix, m, n);
        int right= solve(row, col+1, matrix, m, n);
        int diag= solve(row+1, col+1, matrix, m, n);
        if(matrix[row][col] == '1'){
            int sideLen = 1 + Math.min(bottom, Math.min(right, diag));
            maxSideLen = Math.max(maxSideLen , sideLen);
            return sideLen;
        }
        else return 0;
    }
}




