// T->O(m+n-2)=O(m+n) , SC->O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,cols=matrix[0].length;
        // starting with top-right element.
        int i=0,j=cols-1;
        while(i<rows && j>=0){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j--;
            else i++;
        }
        return false; 
    }
}