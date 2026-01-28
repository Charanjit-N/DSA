// TC --> o( m x n)
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int negCnt = 0;
        int n = matrix.length;
        long sum = 0;
        int maxNeg = -(int)1e9;
        int minPos = (int)1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] < 0) {
                    negCnt++;
                    maxNeg = Math.max(maxNeg, matrix[i][j]);
                }else{
                    minPos = Math.min(minPos, matrix[i][j]);
                }
                sum +=  Math.abs(matrix[i][j]);
            }
        }
        int sub =  Math.min(minPos, Math.abs(maxNeg));
        if(negCnt % 2 == 0) return sum;
        if(sub < 0) sum += 2*sub;
        else sum -= 2*sub;
        return sum;
    }
}