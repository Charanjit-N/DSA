// TC -->O(m x n)
class Solution {
    boolean check(int[] a, int[] b , int[] c){
        if((a[0]==a[1]) && (a[1]==a[2]) && (a[2]==b[0])  && (b[0]==b[1])  && (b[1]==b[2])  && (b[2]==c[0])  && (c[0]==c[1])){
            return true;
        }
        return false;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] hash = new int[16];
        
        int cnt = 0;
        int[] rowSum =  new int[3];
        int[] colSum = new int[3];
        int[] diagSum = new int[2];
        
     
        for(int i = 2;i<m;i++){

            for(int j =2;j<n;j++){
                

                colSum[0] = grid[i-2][j-2] + grid[i-1][j-2] + grid[i-0][j-2];
                colSum[1] = grid[i-2][j-1] + grid[i-1][j-1] + grid[i-0][j-1];
                colSum[2] = grid[i-2][j-0] + grid[i-1][j-0] + grid[i-0][j-0];

                rowSum[0] = grid[i-2][j-2] + grid[i-2][j-1] + grid[i-2][j-0];
                rowSum[1] = grid[i-1][j-2] + grid[i-1][j-1] + grid[i-1][j-0];
                rowSum[2] = grid[i-0][j-2] + grid[i-0][j-1] + grid[i-0][j-0];
                
                diagSum[0] = grid[i-2][j-2]+ grid[i-1][j-1] + grid[i-0][j-0];
                diagSum[1] = grid[i-2][j-0] + grid[i-1][j-1] + grid[i-0][j-2];

               

                boolean bn  = true;
                for(int x = i-2;x<=i;x++){
                    for(int y=j-2;y<=j;y++){
                        if(hash[grid[x][y]] >= 1 || grid[x][y] > 9 || grid[x][y] < 1){
                            bn = false;
                            break;
                        }
                        hash[grid[x][y]]++;
                    }
                    if(bn == false) break;
                }


                if(bn && check(rowSum, colSum, diagSum)) cnt++;


                Arrays.fill(hash, 0);


            }
        }
        return cnt;
    
    }
}