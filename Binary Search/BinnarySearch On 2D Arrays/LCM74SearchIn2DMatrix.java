// TC -->O(log (mxn))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row =  mid/n;
            int col = mid%n;
            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) high = mid-1;
            else low = mid+1;
        }
        return false;
        
    }
}


// TC -->O(logm + logn) = O(log(mxn))
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean bn = false;
        int low = 0, high = rows-1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][0]==target) {bn = true; break;}
            else if(matrix[mid][0] < target) low = mid+1;
            else high =mid-1;
        }
        if(bn) return bn;

        int reqRow = high;
        if(reqRow<0 || reqRow>=rows) return false;
        low = 0;
        high=cols-1; 
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[reqRow][mid]==target) {bn = true; break;}
            else if(matrix[reqRow][mid] < target) low = mid+1;
            else high =mid-1;
        }
        return bn;
        
    }
}