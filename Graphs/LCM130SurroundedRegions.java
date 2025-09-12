// TC->O(N)+O(M)+O(mxnx4)= O(mxn) , SC->O(mxn)+O(mxn)+O(2x4)=O(mxn)
class Solution {
    void dfs(int r, int c, char[][] board, int[][] vis, int[] drow, int[] dcol){
        vis[r][c] = 1;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<4;i++){
            int nr = r + drow[i];
            int nc = c + dcol[i];
            if(nr >=0  && nr <m && nc>=0 && nc<n && vis[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(nr, nc , board, vis, drow, dcol);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        for(int i =0;i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,board,vis,drow,dcol);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(i,n-1,board,vis,drow,dcol);
            }
        }
        for(int j =0;j<n;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0,j,board,vis,drow,dcol);
            }
            if(vis[m-1][j]==0 && board[m-1][j]=='O'){
                dfs(m-1,j,board,vis,drow,dcol);
            }
        }

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(vis[i][j]!=1 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
