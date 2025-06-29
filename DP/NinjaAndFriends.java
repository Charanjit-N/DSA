// Recursion : TC-> O(3^m x 3^m) : Both robot1 and robot2 has three choices and they travel the path length of m, SC->O(m) : recursion stack 
class Solution {
    int solve(int row, int col1, int col2,int m, int n , int[][] grid){
        if(col1<0 || col2<0 ||col1 >=n ||col2 >=n) return 0;
        if(row == m-1){
            if(col1 == col2) return grid[row][col1];
            else return grid[row][col1] +  grid[row][col2];
        }

        int max = (int)-1e9;
        for(int dcol1=-1 ;dcol1<=1;dcol1++){
            for(int dcol2=-1 ;dcol2<=1;dcol2++){
                int val = 0;
                if(col1 == col2) val = grid[row][col1];
                else val = grid[row][col1] +  grid[row][col2];
                val += solve(row+1 , col1+dcol1 ,col2+dcol2,m,n,grid);
                max =  Math.max(max,val);
            }
        }
        return max;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(0,0,n-1,m,n,grid);
        
    }
}

//Memoization : TC-> O(m x n x n x 9) : No of new states/calls we make and we have two for loops(3x3) in each
//SC->O(m) : recursion stack space + O(m x n x n) : dp array
class Solution {
    int solve(int row, int col1, int col2,int m, int n , int[][] grid,int[][][] dp){
        if(col1<0 || col2<0 ||col1 >=n ||col2 >=n) return 0;
        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];
        if(row == m-1){
            if(col1 == col2) return grid[row][col1];
            else return grid[row][col1] +  grid[row][col2];
        }
        int max = (int)-1e9;
        for(int dcol1=-1 ;dcol1<=1;dcol1++){
            for(int dcol2=-1 ;dcol2<=1;dcol2++){
                int val = 0;
                if(col1 == col2) val = grid[row][col1];
                else val = grid[row][col1] +  grid[row][col2];
                val += solve(row+1 , col1+dcol1 ,col2+dcol2,m,n,grid,dp);
                max =  Math.max(max,val);
            }
        }
        return dp[row][col1][col2] = max;
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,n-1,m,n,grid,dp);
    }
}

// Tabulation : TC-> O(m x n x n x 9), SC->(m x n x n) : dp array
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int col1=0;col1<n;col1++){
            for(int col2 = 0;col2<n;col2++){
                if(col1 == col2) dp[m-1][col1][col2]  =  grid[m-1][col1];
                else dp[m-1][col1][col2] =  grid[m-1][col1] +  grid[m-1][col2];
            }
        }
        for(int row=m-2;row >= 0;row--){
            for(int col1=0;col1<n;col1++){
                for(int col2=0;col2<n;col2++){
                    int max = (int)-1e9;
                    for(int dcol1=-1 ;dcol1<=1;dcol1++){
                        for(int dcol2=-1 ;dcol2<=1;dcol2++){
                            int val = 0;
                            if(col1 == col2) val = grid[row][col1];
                            else val = grid[row][col1] +  grid[row][col2];
                            if(col1+dcol1 >= 0 && col1+dcol1 < n && col2+dcol2 >=0 && col2+dcol2 < n){
                                val += dp[row+1][col1+dcol1][col2+dcol2];
                            }
                            else{
                                val += (int)-1e9;
                            }
                            max =  Math.max(max,val);
                        }
                    }
                    dp[row][col1][col2] = max;
                }
            }
        }
        return dp[0][0][n-1];
    }
}

//Tabulation with space optimization : TC-> O(m x n x n x 9)  , SC->(n x n) 
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] next = new int[n][n];
        int[][] cur = new int[n][n];
 
        for(int col1=0;col1<n;col1++){
            for(int col2 = 0;col2<n;col2++){
                if(col1 == col2) next[col1][col2]  =  grid[m-1][col1];
                else next[col1][col2] =  grid[m-1][col1] +  grid[m-1][col2];
            }
        }
        for(int row=m-2;row >= 0;row--){
            for(int col1=0;col1<n;col1++){
                for(int col2=0;col2<n;col2++){
                    int max = (int)-1e9;
                    for(int dcol1=-1 ;dcol1<=1;dcol1++){
                        for(int dcol2=-1 ;dcol2<=1;dcol2++){
                            int val = 0;
                            if(col1 == col2) val = grid[row][col1];
                            else val = grid[row][col1] +  grid[row][col2];
                            if(col1+dcol1 >= 0 && col1+dcol1 < n && col2+dcol2 >=0 && col2+dcol2 < n){
                                val += next[col1+dcol1][col2+dcol2];
                            }
                            else{
                                val += (int)-1e9;
                            }
                            max =  Math.max(max,val);
                        }
                    }
                    cur[col1][col2] = max;
                }
            }
            for(int col1=0;col1<n;col1++){
                for(int col2=0;col2<n;col2++){
                    next[col1][col2] =  cur[col1][col2];
                }
            }

        }
        return next[0][n-1];
        
    }
}