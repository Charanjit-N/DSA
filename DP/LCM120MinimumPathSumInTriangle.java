
// Recursion :  
// Total states: In firt rwo : 1, second row = 2 ..... in nth row = n =>  n*(n+1)/2
// TC->O(2^(nxn)) : we have two possibilities down, diag for each state
//SC->O(n): path/recursion stack space/ height of recursion tree

class Solution {
    int solve(int row,int col,int size, List<List<Integer>> triangle){
        if(row == size-1) return  triangle.get(row).get(col);
        int down = triangle.get(row).get(col) + solve(row+1, col,size, triangle);
        int diag = triangle.get(row).get(col) + solve(row+1, col+1,size, triangle);
        return Math.min(down, diag);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int size  = triangle.size();
        return solve(0,0,size,triangle);
        
    }
}

// Memoization :  TC->O(nxn)  , SC->O(n): path/recursion stack space/ height of recursion tree + O(nxn): dp array
class Solution {
    int solve(int row,int col,int size, List<List<Integer>> triangle,int[][] dp){
        if(row == size-1) return  triangle.get(size-1).get(col);
        if(dp[row][col] != -1) return dp[row][col];
        int down = triangle.get(row).get(col) + solve(row+1, col,size, triangle,dp);
        int diag = triangle.get(row).get(col) + solve(row+1, col+1,size, triangle,dp);
        return dp[row][col] = Math.min(down, diag);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int size  = triangle.size();
        int[][] dp = new int[size][size]; 
        for(int i=0;i<size;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,size,triangle,dp);
        
    }
}

// Tabulation : TC-->O(nxn), SC->O(nxn)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size  = triangle.size();
        int[][] dp = new int[size][size]; 
        // base casses in recursion
        for(int j =0 ;j<size;j++){
            dp[size-1][j] = triangle.get(size-1).get(j);
        }
        for(int i=size-2;i>=0;i--){
            for(int j=i; j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j]; 
                int diag = triangle.get(i).get(j) + dp[i+1][j+1]; 
                dp[i][j]= Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}

// Tabulation with space optimized : TC-->O(nxn), SC->O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size  = triangle.size();
        int[] nextRow = new int[size]; 
        // base casses in recursion
        for(int j =0 ;j<size;j++){
            nextRow[j] = triangle.get(size-1).get(j);
        }
        for(int i=size-2;i>=0;i--){
            int[] curr = new int[size];
            for(int j=i; j>=0;j--){
                int down = triangle.get(i).get(j) + nextRow[j]; 
                int diag = triangle.get(i).get(j) + nextRow[j+1]; 
                curr[j]= Math.min(down, diag);
            }
            for(int j=0;j<size;j++){
                nextRow[j] =  curr[j];
            }
        }
        return nextRow[0];
    }
}