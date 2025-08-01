// using Dijkstra Algo
// TC->O(E logV) = O(mxnx4 log(mxn)) = O(mxn*log(mxn))
// SC->O(mxn)
class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length; 
        int n = heights[0].length; 
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0] = 0; 
        pq.add(new Tuple(0, 0, 0)); 
        int drow[] = {-1, 0, 1, 0}; 
        int dcol[] = {0, 1, 0, -1}; 
        while(pq.size() != 0) {
            Tuple t = pq.peek(); 
            pq.remove(); 
            int diff = t.distance; 
            int r = t.row; 
            int c = t.col; 
            // if(r == n-1 && c == m-1) return diff; 
            for(int i = 0;i<4;i++) {
                int nr = r + drow[i]; 
                int nc = c + dcol[i];
                if(nr>=0 && nc >=0 && nr < m && nc < n) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), diff); 
                    if(newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort; 
                        pq.add(new Tuple(newEffort, nr, nc)); 
                    }
                }
            }
        }
        // return 0;
        return dist[m-1][n-1];
    }
}

// Binary Search  + DFS(or) BFS
//  DFS  TC -> O(V + 2E) v = mxn, E = mxnx4=> DF TC->O(mxn)
// TC->O(DFS TC * log(10^6)) =  O(mxnxlog(10^6))
// SC->O(V) = O(mxn)
class Solution {
     boolean dfs(int r, int c, int[][] heights, boolean[][] vis, int maxEffort) {
        int n = heights.length, m = heights[0].length;
        if (r == n - 1 && c == m - 1) return true;
        vis[r][c] = true;
        int[] drow  = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        for (int i =0;i<4;i++) {
            int nr = r + drow[i];
            int nc = c + dcol[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                int effort = Math.abs(heights[nr][nc] - heights[r][c]);
                if (effort <= maxEffort) {
                    if (dfs(nr, nc, heights, vis, maxEffort)) return true;
                }
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int low = 0;
        int high = (int) 1e6;
        int ans = 0;
        while(low <= high){
            int mid =  low + (high -low)/2;
            boolean[][] vis = new boolean[n][m];
            if(dfs(0, 0, heights, vis, mid)){
                ans =  mid;
                high = mid-1;
            }
            else{
                low =  mid + 1;
            }
        }
        return ans;
    }
}



// recursion
class Solution {
    void solve(int r, int c, int[][] heights, int currMax, int[][] vis, int[] ans) {
        if (r == heights.length - 1 && c == heights[0].length - 1) {
            ans[0] = Math.min(ans[0], currMax);
            return;
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + drow[i];
            int nc = c + dcol[i];

            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && vis[nr][nc] == 0) {
                vis[nr][nc] = 1;
                int effort = Math.abs(heights[nr][nc] - heights[r][c]);
                solve(nr, nc, heights, Math.max(currMax, effort), vis, ans);
                vis[nr][nc] = 0; // backtrack
            }
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[] ans = new int[]{Integer.MAX_VALUE};
        int[][] vis = new int[heights.length][heights[0].length];
        vis[0][0] = 1;
        solve(0, 0, heights, 0, vis, ans);
        return ans[0];
    }
}


// Memoization
//dp[r][c] stores the minimum effort recorded so far to reach (r, c) in any recursive path.
class Solution {
    int dfs(int r, int c, int[][] heights, int[][] vis, int maxEffort,int[][] dp) {
        int n = heights.length, m = heights[0].length;
        if (r == n - 1 && c == m - 1) return maxEffort;
        if (dp[r][c] != -1 && dp[r][c] <= maxEffort) return Integer.MAX_VALUE;
        dp[r][c] = maxEffort;
        int minAns = Integer.MAX_VALUE;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + drow[i];
            int nc = c + dcol[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0) {
                vis[nr][nc] = 1;
                int effort = Math.abs(heights[nr][nc] - heights[r][c]);
                int result = dfs(nr, nc, heights, vis, Math.max(maxEffort, effort),dp);
                minAns = Math.min(minAns, result);
                vis[nr][nc] = 0; // backtrack
            }
        }
        return minAns;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int[][] vis = new int[n][m];
        vis[0][0] = 1;
        return dfs(0, 0, heights, vis, 0,dp);
    }
}


// Tabulation 
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp){Arrays.fill(row, Integer.MAX_VALUE);}
        dp[0][0] = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        boolean updated;
        do {        // Keep updating until no more improvement
            updated = false;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    for (int i =0;i<4;i++) {
                        int nr = r + drow[i];
                        int nc = c + dcol[i];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            int effort = Math.abs(heights[r][c] - heights[nr][nc]);
                            int maxEffort = Math.max(dp[r][c], effort);
                            if (dp[nr][nc] > maxEffort) {
                                dp[nr][nc] = maxEffort;
                                updated = true;
                            }
                        }
                    }
                }
            }

        } while (updated); // Repeat until no more updates
        return dp[n - 1][m - 1];
    }
}
