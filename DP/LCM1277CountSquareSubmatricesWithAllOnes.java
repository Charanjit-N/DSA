// Tabulation approach : TC->O(mxn) , SC->O(mxn)
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j=0;j<n;j++) dp[0][j] = matrix[0][j];
        for(int i=0;i<m;i++) dp[i][0] = matrix[i][0];
        for(int i=1;i<m;i++){
            for(int j =1;j<n;j++){
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cnt =  cnt + dp[i][j];
            }
        }
        
        return cnt;
    }
}