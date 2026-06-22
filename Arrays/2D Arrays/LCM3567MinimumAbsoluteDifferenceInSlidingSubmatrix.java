
// TC -> O((m-k) x (n-k) x (k^2*log(k^2)) )
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
     
        int[][] ans = new int[m-k+1][n-k+1];

       
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
               
                List<Integer> ls = new ArrayList<>();
                for(int row = i; row < i+k ;row++){
                    for(int col = j;col < j+k;col++){
                        ls.add(grid[row][col]);
                    }
                }
                Collections.sort(ls);
                int minAbsDiff = Integer.MAX_VALUE;
                int prev = ls.get(0);
                for(int x =1;x < ls.size();x++){
                    int cur = ls.get(x);
                    if(cur != prev){
                        minAbsDiff = Math.min(minAbsDiff , cur - prev);
                        prev =  cur;
                    }
                }
                ans[i][j] = (minAbsDiff == Integer.MAX_VALUE) ? 0 : minAbsDiff;
                
            }
        }
        return ans;
        
    }
}