// TC->O(4xmxn )=O(mxn) , SC->O(mxn)
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row =  row;
        this.col =  col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] ans =  image;
        int startColor = image[sr][sc];
        ans[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            for(int i =0;i<4;i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==startColor && ans[nr][nc]!=color){
                    q.add(new Pair(nr,nc));
                    ans[nr][nc] = color;
                }
            }
        }
        return ans;
    }
}