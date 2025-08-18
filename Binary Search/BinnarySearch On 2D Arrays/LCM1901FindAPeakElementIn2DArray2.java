// Optimal : TC-> O(m x log(n)) , SC->O(1)
class Solution {
    // Finding the max element in that column.
    int findRowIndex(int[][] mat, int colIndex){
        int maxElement = -1;
        int maxElementRowIndex = -1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][colIndex]>maxElement){
                maxElement = mat[i][colIndex];
                maxElementRowIndex = i;
            }
        }
        return maxElementRowIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
    
       int rows = mat.length;
       int cols = mat[0].length;
       int low = 0, high = cols-1;
       while(low<=high){
        int mid = low+(high-low)/2;
        int rowIndex = findRowIndex(mat,mid);   // TC->O(rows)
        int left = mid-1 >=0 ? mat[rowIndex][mid-1]:-1;
        int right = mid+1 < cols ? mat[rowIndex][mid+1]:-1;
        if(mat[rowIndex][mid]>left && mat[rowIndex][mid]>right) return new int[]{rowIndex,mid};
        else if(mat[rowIndex][mid]<left) high = mid-1;
        else low = mid+1;
       }
       return new int[]{-1,-1};

    // Brute Force : Max Element will always be peak element. TC->O(mxn);sc->O(1)
    //    int rows = mat.length;
    //    int cols = mat[0].length;
    //    int max = -1;
    //    int rowIndex = -1,colIndex =-1;
    //    for(int i=0;i<rows;i++){
    //     for(int j=0;j<cols;j++){
    //        if(mat[i][j]>max){
    //         max = mat[i][j];
    //         rowIndex = i;
    //         colIndex = j;
    //        }
    //     }
    //    }
    //    return new int[]{rowIndex,colIndex};
        
    }
}