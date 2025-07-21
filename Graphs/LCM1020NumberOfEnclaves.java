// TC->O(mxnx4) = O(mxn) , SC->O(mxn) +O(mxn)= O(mxn)
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q =  new LinkedList<>();
        int[][] vis = new int[m][n];
        for(int i =0;i<m;i++){
            if(grid[i][0]==1){
                q.add(new Pair(i,0));
                vis[i][0]=1;
            }
            if(grid[i][n-1]==1){
                q.add(new Pair(i,n-1));
                vis[i][n-1]=1;
            }
        }
        for(int j =0;j<n;j++){
            if(grid[0][j]==1){
                q.add(new Pair(0,j));
                vis[0][j]=1;
            }
            if(grid[m-1][j]==1){
                q.add(new Pair(m-1,j));
                vis[m-1][j]=1;
            }
        }
        int[] drow = {-1,0,+1,0};
        int[] dcol =  {0,+1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c =  p.col;
            for(int i=0;i<4;i++){
                int nr =  r + drow[i];
                int nc  = c + dcol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}