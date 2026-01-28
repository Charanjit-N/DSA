// TC ->O(m + n) 
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i=0, j= n-1;
        int cntNeg = 0;
        while(i < m && j>=0){
            if(grid[i][j] >= 0){
                cntNeg += (n -1 - j);
                i++;
            }else{
                j--;
            }
        }
        if(i <= m){
            if(j < 0){
                cntNeg += (m-i)*n;
            }
        }
        return cntNeg;
    }
}

// TC -->O(m+n)
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = m - 1, j = 0;
        int res = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                res += n - j;
                i--;
            } else
                j++;
        }
        return res;
    }
}
