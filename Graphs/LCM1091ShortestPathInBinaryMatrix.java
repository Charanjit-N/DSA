//using normal BFS : TC->O(V + 2E) v = mxn , E = mxnx8 => TC->O(mxn), SC->O(mxn)
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row =  row;
        this.col =  col;
    }
}
class Solution {
    int findShortestPath(int starti,int startj, int desti, int destj,int[][] grid){
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], (int)1e9);
        }
        if(grid[starti][startj]==0){
            dist[starti][startj] = 0;
            q.add(new Pair(starti,startj));
        }
        int[] drow = {-1,-1,0,+1,+1,+1,0,-1};
        int[] dcol = {0,+1,+1,+1,0,-1,-1,-1};
        while(!q.isEmpty()){
            Pair p =  q.poll();
            int r = p.row;
            int c =  p.col;
            for(int i=0;i<8;i++){
                int nr  =  r + drow[i];
                int nc =  c + dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]== 0){
                    if(1 + dist[r][c] < dist[nr][nc]){
                        dist[nr][nc] =  1 + dist[r][c];
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        return dist[desti][destj]==(int)1e9 ? -1 : dist[desti][destj] + 1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        return findShortestPath(0,0,n-1,n-1,grid);
    }
}

// Dijkstra Algo : O(E * logV) , E = (8xmxn) V =mxn
class Tuple{
    int distance;
    int row;
    int col;
    Tuple(int distance,int row, int col){
        this.distance =  distance;
        this.row =  row;
        this.col =  col;
    }
}
class Solution {
    int dijkstra(int starti,int startj, int desti, int destj,int[][] grid){
        int n = grid.length;
        PriorityQueue<Tuple> q = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], (int)1e9);
        }

        if(grid[starti][startj]==0){
            dist[starti][startj] = 0;
            q.add(new Tuple(0,starti,startj));
        }
        int[] drow = {-1,-1,0,+1,+1,+1,0,-1};
        int[] dcol = {0,+1,+1,+1,0,-1,-1,-1};
        while(!q.isEmpty()){
            Tuple t =  q.poll();
            int r = t.row;
            int c =  t.col;
            int dis =  t.distance;
            for(int i=0;i<8;i++){
                int nr  =  r + drow[i];
                int nc =  c + dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]== 0){
                    if(1 + dis < dist[nr][nc]){
                        dist[nr][nc] =  1 + dis;
                        q.add(new Tuple(dist[nr][nc] ,nr,nc));
                    }
                }
            }
        }
        return dist[desti][destj]==(int)1e9 ? -1 : dist[desti][destj] + 1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        return dijkstra(0,0,n-1,n-1,grid);
    }
}