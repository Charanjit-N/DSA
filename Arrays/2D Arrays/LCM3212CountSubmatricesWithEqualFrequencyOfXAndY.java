// TC -> O(m x n), SC->O(m x n)
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSumX = new int[m][n];
        int[][] preSumY = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    preSumX[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                }
                else{
                    preSumX[i][j] = preSumX[i][j-1] + ((grid[i][j] == 'X') ? 1 : 0);
                }
            }
        }
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                preSumX[i][j] += preSumX[i-1][j];       
            }
        }        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    preSumY[i][j] = (grid[i][j] == 'Y') ? 1 : 0;
                }
                else{
                    preSumY[i][j] = preSumY[i][j-1] + ((grid[i][j] == 'Y') ? 1 : 0);
                }
            }
        }
        for(int j=0;j<n;j++){
            for(int i=1;i<m;i++){
                preSumY[i][j] += preSumY[i-1][j];       
            }
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( (preSumX[i][j] == preSumY[i][j]) && (preSumX[i][j] > 0)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}









