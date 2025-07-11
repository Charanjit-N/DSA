//Optimal : TC->  O(M*N) + O(M^2 * N) = (approx) O(n^3)
class LCH1074CountSubMatricesWhoseSumEqualsK {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Precomputing prefix Sum matrix
        int[][] preSum = new int[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c =0;c<cols;c++){
                int top = 0,left=0,topLeft=0;
                if(r>0) top = preSum[r-1][c];
                if(c>0) left = preSum[r][c-1];
                if(r>0 && c>0) topLeft = preSum[r-1][c-1];
                preSum[r][c] = matrix[r][c] + top + left - topLeft;
            }
        }

        int res = 0;
        
        for(int r1 =0;r1<rows;r1++){
            for(int r2=r1;r2<rows;r2++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for(int c=0;c<cols;c++){
                    int curSum = preSum[r2][c] - ( (r1>0) ? preSum[r1-1][c] : 0 );
                    int remianing = curSum - target;
                    res = res + map.getOrDefault(remianing,0);
                    map.put(curSum,map.getOrDefault(curSum,0)+1);

                }
            }
        }

        return res;
    }
}


// TC-> O(M*N) + O(M^2 * N^2) = (approx) O(n^4)
class LCH1074CountSubMatricesWhoseSumEqualsK{
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols= matrix[0].length;

        // Precomputing prefix Sum matrix
        int[][] preSum = new int[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                int top = 0, left=0,topLeft=0;
                if(r>0) top = preSum[r-1][c];
                if(c>0) left = preSum[r][c-1];
                if(r>0 && c>0) topLeft = preSum[r-1][c-1];
                preSum[r][c] = matrix[r][c] + top + left - topLeft;
            }
        }

        for(int i=0;i<preSum.length;i++){
            System.out.println(Arrays.toString(preSum[i]));
        }
        int cnt =0;

        for(int r1=0;r1<rows;r1++){
            for(int r2=r1;r2<rows;r2++){
                for(int c1=0;c1<cols;c1++){
                    for(int c2=c1;c2<cols;c2++){
                        int top =0, left=0,topLeft=0;
                        if(r1>0) top = preSum[r1-1][c2];
                        if(c1>0) left = preSum[r2][c1-1];
                        if(r1>0 && c1>0) topLeft = preSum[r1-1][c1-1];
                        int curSum = preSum[r2][c2]-top-left+topLeft;
                        if(curSum == target) cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}