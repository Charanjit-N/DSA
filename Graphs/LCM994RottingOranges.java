
// TC->O(m*n) , SC->O(m*n)
class Tuple{
    int row;
    int col;
    int time;
    Tuple(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m =  grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Tuple> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Tuple(i,j,0));
                    vis[i][j] = 2; // Marking visted oranges as 2.
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int tm = 0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        while(!q.isEmpty()){
            Tuple nd = q.poll();
            int r = nd.row ;
            int c =  nd.col;
            int t =  nd.time;
            tm = Math.max(tm,t);
            for(int i=0;i<4;i++){
                int nr = r + drow[i];
                int nc =  c + dcol[i];
                if(nr >= 0 && nr < m && nc >=0 && nc<n && grid[nr][nc] == 1 && vis[nr][nc] != 2 ){
                    q.add(new Tuple(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cntFresh--;
                }
            }
        }
        return cntFresh == 0 ? tm : -1;
    }
}