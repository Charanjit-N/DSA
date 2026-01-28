// TC --> O(N ^ 4)
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowPrefixSum = new int[m][n];
        int[][] colPrefixSum = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j ==0){
                    rowPrefixSum[i][j] = grid[i][j];
                }else{
                    rowPrefixSum[i][j] = grid[i][j] + rowPrefixSum[i][j-1];
                }   

                if(i == 0){
                    colPrefixSum[i][j] = grid[i][j];
                }else{
                    colPrefixSum[i][j] = grid[i][j] + colPrefixSum[i-1][j]; 
                }
            }
        }

        int maxMagicSquareLen = 1;

        int maxSize = Math.min(m,n);
        for(int size=2;size<=maxSize;size++){
            int i1=0, i2 = size-1;
            while(i2 < m){
                int j1 = 0, j2 = size-1;
                while(j2 < n){
                    int val =  rowPrefixSum[i1][j2] - ((j1 == 0) ? 0 : rowPrefixSum[i1][j1-1]);
                    boolean bn = true;
                    for(int row = i1+1;row<=i2;row++){
                        int rowSum = rowPrefixSum[row][j2] - ((j1 == 0) ? 0 : rowPrefixSum[row][j1-1]);
                        if(rowSum != val){
                            bn = false;
                            break;
                        }
                    }
                    if(bn == true){
                        for(int col = j1;col<=j2;col++){
                            int colSum = colPrefixSum[i2][col] - ((i1==0) ? 0 : colPrefixSum[i1-1][col]);
                            if(colSum != val){
                                bn = false;
                                break;
                            }
                        }

                    }
                    if(bn == true){
                        int diagSum = grid[i1][j1];
                        int antiDiagSum = grid[i1][j1+size-1];
                        for(int x = 1; x < size;x++){
                            diagSum += grid[i1+x][j1+x];
                            antiDiagSum += grid[i1+x][j1+size-1-x];
                        }
                        if(diagSum != val) bn = false;
                        if(antiDiagSum != val) bn = false;

                    }

                    if(bn == true){
                        maxMagicSquareLen = Math.max(maxMagicSquareLen, size);
                    }

                    j1++;
                    j2++;
                }
                i1++;
                i2++;
            }
        }
        return maxMagicSquareLen;   
    }
}