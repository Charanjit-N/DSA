// TC -> O(m x n)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0 ;i < m ;i++){
            for(int j=0; j<n ; j++){
                if(j > 0) grid[i][j] += grid[i][j-1];
            }
        }

        for(int j=0;j<n;j++){
            for(int i=0; i<m; i++){
                if(i > 0) grid[i][j] += grid[i-1][j];
            }
        }

        int cnt = 0;
        for(int i =0; i <m ;i++){
            for(int j =0 ; j< n ; j++){
                if(grid[i][j] <= k) cnt++;
            }
        }

        return cnt;
        
    }
}