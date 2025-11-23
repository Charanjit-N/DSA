// TC ->O(n x q) + O(n x n)
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for(int[] q : queries){
            int r1 =  q[0];
            int r2 =  q[2];
            int c1 = q[1];
            int c2 = q[3];
            for(int i=r1;i<=r2;i++){
                ans[i][c1]++;
                if(c2+1<n) ans[i][c2+1]--;
            }
        }
        for(int r=0;r<n;r++){
            for(int c =1;c<n;c++){
                ans[r][c] = ans[r][c] + ans[r][c-1];
            }
        }
        return ans;
    }
}

