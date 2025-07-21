// Using BFS : TC->O(mxn)*log(mxn) (log for set operations) + O(mxnx4) = O(mxnnlog(mxn)), SC->O(mxn + mxn) =O(mxn)
import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row =  row;
        this.col = col;
    }
}
class TUFNumberOfDistinctIslands {
    void bfs(int startrow, int startcol, int[][] grid, int[][] vis, ArrayList<String> ls){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startrow, startcol));
        vis[startrow][startcol] =1;
        ls.add(Integer.toString(0)+" "+Integer.toString(0));
        int[] drow = {-1,0,+1,0};
        int[] dcol =  {0,+1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c =  p.col;
            for(int i=0;i<4;i++){
                int nr =  r + drow[i];
                int nc =  c + dcol[i];
                if(nr>=0  && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr, nc));
                    ls.add(Integer.toString(nr-startrow)+" "+Integer.toString(nc -  startcol));
                    vis[nr][nc]=1;
                }
            }
        }
    }
    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Set<ArrayList<String>> s = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ArrayList<String> ls =  new ArrayList<>();
                    bfs(i,j,grid,vis,ls);
                    s.add(ls);
                }
            }
        }
        return s.size(); 
    }
}


// Using DFS : TC->O(mxn)*log(mxn) (log for set operations) + O(mxnx4) = O(mxnnlog(mxn)), SC->O(mxn + mxn) =O(mxn)
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row =  row;
        this.col = col;
    }
}
class TUFNumberOfDistinctIslands {
    void dfs(int startrow, int startcol, int r, int c, int[][] grid, int[][] vis, ArrayList<String> ls){
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] =1;
        ls.add(Integer.toString(r-startrow)+" "+Integer.toString(c-startcol));
        int[] drow = {-1,0,+1,0};
        int[] dcol =  {0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nr =  r + drow[i];
            int nc =  c + dcol[i];
            if(nr>=0  && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                dfs(startrow, startcol, nr, nc, grid, vis, ls);
            }
        }
    }
    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Set<ArrayList<String>> s = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ArrayList<String> ls =  new ArrayList<>();
                    dfs(i,j,i,j,grid,vis,ls);
                    s.add(ls);
                }
            }
        }
        return s.size();      
    }
}
