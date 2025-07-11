/*Consider a rat placed at position (0, 0) in an n x n square matrix mat. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list.+

The task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.

Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

*/


// TC-> Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
// We first explore possibilities using recursion in order D->L->R->U (alphabetical order), So that at the end we get the answers in lexicographical/alphabetical/dictionary order
class GFG_RatInAMaze1 {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        int n = mat.size();
        ArrayList<String> res = new ArrayList<>();
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(visited[i],0);
        int dr[] = {1,0,0,-1};
        int dc[] = {0,-1,1,0};
        findPath(mat,n,0,0,new StringBuffer(),res,visited,dr,dc);
        return res;
    }
    
    void findPath(ArrayList<ArrayList<Integer>> mat,int n , int row, int col, StringBuffer sb,ArrayList<String> res,int[][] visited,int[] dr, int[] dc){
        if(row == n-1 && col==n-1){
            res.add(new String(sb));
            return;
        }
        String dir = "DLRU";
        for(int i=0;i<4;i++){
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if(nextRow<n && nextCol<n && nextRow>=0&& nextCol>=0 && visited[nextRow][nextCol]==0 && mat.get(nextRow).get(nextCol)==1){
                visited[row][col]=1;
                sb.append(dir.charAt(i));
                findPath(mat,n,nextRow,nextCol,sb,res,visited,dr,dc);
                visited[row][col]=0;
                sb.deleteCharAt(sb.length()-1);  
            }
            
            
        }

        // Instead of writing for all four directions like below we can write a for loop like above using de[] and dc[]
        
        /*
        // down
        if(row+1<n && visited[row+1][col]==0 && mat.get(row+1).get(col)==1){
            visited[row][col]=1;
            sb.append('D');
            findPath(mat,n,row+1,col,sb,res,visited);
            visited[row][col]=0;
            sb.deleteCharAt(sb.length()-1);  
        }
        
        //left
        if(col-1>=0 && visited[row][col-1]==0 && mat.get(row).get(col-1)==1){
            visited[row][col]=1;
            sb.append('L');
            findPath(mat,n,row,col-1,sb,res,visited);
            visited[row][col]=0;
            sb.deleteCharAt(sb.length()-1);  
        }
        
        // right
        if(col+1<n && visited[row][col+1]==0 && mat.get(row).get(col+1)==1){
            visited[row][col]=1;
            sb.append('R');
            findPath(mat,n,row,col+1,sb,res,visited);
            visited[row][col]=0;
            sb.deleteCharAt(sb.length()-1);  
        }
        //up
        if(row-1>=0 && visited[row-1][col]==0 && mat.get(row-1).get(col)==1){
            visited[row][col]=1;
            sb.append('U');
            findPath(mat,n,row-1,col,sb,res,visited);
            visited[row][col]=0;
            sb.deleteCharAt(sb.length()-1);  
        }
        */
    }
}