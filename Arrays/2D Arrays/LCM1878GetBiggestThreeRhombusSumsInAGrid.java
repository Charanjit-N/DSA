class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diagSum1 = new int[m][n];
        int[][] diagSum2 = new int[m][n];
        PriorityQueue<Integer> pq =  new PriorityQueue<>((x,y) -> y-x);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(i == 0 || j==0) diagSum1[i][j] = grid[i][j];
                else{
                    diagSum1[i][j] = diagSum1[i-1][j-1] + grid[i][j]; 
                }
                if(i == 0 || j == n-1) diagSum2[i][j] = grid[i][j];
                else{
                    diagSum2[i][j] =  diagSum2[i-1][j+1] + grid[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(grid[i][j]);
                for (int diagLen = i + 2; diagLen < m; diagLen += 2) {
                    int topX = i;
                    int topY = j;
                    int bottomX = diagLen;
                    int bottomY = j;
                    int leftX = (i + diagLen) / 2;
                    int leftY = j - (diagLen - i) / 2;
                    int rightX = (i + diagLen) / 2;
                    int rightY = j + (diagLen - i) / 2;
                    if (leftY < 0 || rightY >= n) {
                        break;
                    }
                    int s1 = diagSum2[leftX][leftY] - ( (topX > 0 && topY < n-1) ? diagSum2[topX-1][topY+1] : 0 );
                    int s2 = diagSum1[rightX][rightY] - ( (topX > 0 && topY > 0) ? diagSum1[topX-1][topY-1] : 0 ) ;
                    int s3 = diagSum2[bottomX][bottomY] -  ((rightX > 0 && rightY < n-1) ? diagSum2[rightX-1][rightY+1] : 0 );
                    int s4 =  diagSum1[bottomX][bottomY] - ( (leftX > 0 && leftY > 0) ? diagSum1[leftX-1][leftY-1] : 0 ) ;
                    int s5 = grid[topX][topY] + grid[bottomX][bottomY] + grid[leftX][leftY]  + grid[rightX][rightY] ;
                    int totSum = s1 + s2 + s3 + s4 - s5;
                    pq.add(totSum);
                }
            }
        }

        Set<Integer> set = new LinkedHashSet<>();
        int pqSize = pq.size();
        for (int i = 0; i < pqSize; i++) {
            set.add(pq.poll());
        }
        int ansLen = Math.min(3,set.size());
        int[] ans = new int[ansLen];
        int index= 0;
        for (Integer x :  set) {
            ans[index++] = x;
            if(index == 3) break;
        }
        return ans;
    }
}