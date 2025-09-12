// TC->O(mxnx4 = mxn), SC->O(mxn)
class Tuple{
    int row;
    int col;
    int dist;
    Tuple(int row, int col, int dist){
        this.row =  row;
        this.col =  col;
        this.dist =  dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Tuple> q = new LinkedList<>();
        int[][] vis =  new int[m][n];
        int[][] ans =  new int[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Tuple(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] drow =  {-1,0,+1,0};
        int[] dcol =  {0,+1,0,-1};
        while(!q.isEmpty()){
            Tuple  t =  q.poll();
            int r = t.row;
            int c = t.col;
            int d = t.dist;
            ans[r][c] = d;
            for(int i=0;i<4;i++){
                int nr =  r + drow[i];
                int nc =  c + dcol[i];
                if(nr>=0 && nr < m  && nc >=0  && nc<n && vis[nr][nc]==0){
                    q.add(new Tuple(nr,nc,d+1));
                    vis[nr][nc] = 1;
                }
            }
        }
        return ans;
    }
}