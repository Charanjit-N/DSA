// TC -> O(m x n) + O(m x nlogn)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int col = 0; col < n ; col++){
            for(int row = 1 ; row < m ; row++){
                if(matrix[row][col] != 0) matrix[row][col] += matrix[row-1][col];
            }
        }
        int ans =  0;
        for(int row = 0; row < m ; row++){
            Arrays.sort(matrix[row]);
            for(int col = 0; col < n; col++){
                ans =  Math.max(ans, matrix[row][col]*(n-col));
            }   
        }
        return ans;
    }
}







