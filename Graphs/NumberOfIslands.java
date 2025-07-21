
// TC->O(mxnx8) = O(mxn) , SC->O(mxn) +O(mxn)= O(mxn)
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class NumberOfIslands {
    void bfs(int startrow, int startcol, int[][] grid, int[][] vis){
        Queue<Pair> q =  new LinkedList<>();
        q.add(new Pair(startrow, startcol));
        vis[startrow][startcol] = 1;
        int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c =  p.col;
            for(int drow=-1;drow<=1;drow++){
                for(int dcol=-1;dcol<=1;dcol++){
                    int nr = r + drow;
                    int nc = c + dcol;
                    if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                        q.add(new Pair(nr,nc));
                        vis[nr][nc]=1;
                    }
                }
            }
        }
    }
    public int numIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    bfs(i,j,grid,vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
}