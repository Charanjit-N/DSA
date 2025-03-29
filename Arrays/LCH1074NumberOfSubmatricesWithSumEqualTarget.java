class LCH1074NumberOfSubmatricesWithSumEqualTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // Optimal : preSum hashing , Similar to LCM560 problem
        // TC-> O(M^2 * N) , SC->O(M * N)   {M-> rows, N-> cols}
        int rows  = matrix.length;
        int cols = matrix[0].length;
        int[][] preSum = new int[rows][cols];
        // Precomputing preSum matrix
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                int top = (r>0) ? preSum[r-1][c]:0; 
                int left = (c>0) ? preSum[r][c-1]:0; 
                int topLeft = (r>0 && c>0) ? preSum[r-1][c-1]:0; 
                preSum[r][c] = matrix[r][c] + top + left - topLeft;

            }
        }

        int cnt = 0;
        for(int r1 =0 ;r1<rows;r1++){
            for(int r2 = r1 ;r2<rows;r2++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0,1);
                int curSum = 0;
                for(int c=0;c<cols;c++){
                    
                    if(r1>0){
                        curSum = preSum[r2][c] - preSum[r1-1][c];
                    }
                    else{
                        curSum = preSum[r2][c];
                    }  
                    int rem = curSum - target;
                    cnt = cnt + map.getOrDefault(rem,0);
                    map.put(curSum , map.getOrDefault(curSum,0)+1);
                }
            }
        }
        return cnt;    

        // Better : Using PreSum : TC->O(M^2 * N^2) , SC->O(M * N)  {M-> rows, N-> cols}
        // int rows  = matrix.length;
        // int cols = matrix[0].length;  
        // int[][] preSum = new int[rows][cols];
        // int cnt = 0;
        // // Precomputing preSum matrix
        // for(int r=0;r<rows;r++){
        //     for(int c=0;c<cols;c++){
        //         int top = (r>0) ? preSum[r-1][c]:0; 
        //         int left = (c>0) ? preSum[r][c-1]:0; 
        //         int topLeft = (r>0 && c>0) ? preSum[r-1][c-1]:0; 
        //         preSum[r][c] = matrix[r][c] + top + left - topLeft;

        //     }
        // }
        // for(int r1=0;r1<rows;r1++){
        //     for(int r2=r1;r2<rows;r2++){
        //         for(int c1=0;r1<cols;c1++){
        //             for(int c2=c1;c2<cols;c2++){
        //                 int top = (r1>0) ? preSum[r1-1][c2]:0; 
        //                 int left = (c1>0) ? preSum[r2][c1-1]:0; 
        //                 int topLeft = (r1>0 && c1>0) ? preSum[r1-1][c1-1]:0; 
        //                 int curSum = matrix[r2][c2] - top - left + topLeft;
        //                 if(curSum == target) cnt++;
        //             }
        //         }
        //     }
        // }
        // return cnt;
        
    }
}