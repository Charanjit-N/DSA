// BFS with Priority Queue
// TC -->O(m x n x  log(mxn)) , SC --> O(m x n)
class Tuple{
    int height;
    int r;
    int c;
    Tuple(int height, int r, int c){
        this.height = height;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];

        for(int r = 0 ;r<m;r++){
            pq.add(new Tuple(heightMap[r][0], r, 0));
            visited[r][0] = true;

            pq.add(new Tuple(heightMap[r][n-1], r, n-1));
            visited[r][n-1] = true;
        }

        for(int c = 0 ;c<n;c++){
            pq.add(new Tuple(heightMap[0][c], 0, c));
            visited[0][c] = true;

            pq.add(new Tuple(heightMap[m-1][c], m-1, c));
            visited[m-1][c] = true;
        }

        int[] dx = {0,-1,0,+1};
        int[] dy = {-1,0,+1,0};
        int water  = 0;
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int height = t.height;
            int row = t.r;
            int col = t.c;
            for(int i=0;i<4;i++){
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                if(newRow >=0  && newRow < m && newCol>=0 && newCol < n && !visited[newRow][newCol]){
                    water += Math.max(height - heightMap[newRow][newCol] , 0);
                    pq.add(new Tuple(Math.max(height,heightMap[newRow][newCol]) , newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return water;
        
    }
}