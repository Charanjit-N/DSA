class GFG_MedianInRowWiseSortedMatrix{
    int upperBound(int[] arr, int val){
        int ans = arr.length; // 'C' here
        int low = 0, high = arr.length -1;
        while(low<=high){
            int mid  = low + (high - low)/2;
            if(arr[mid] > val){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        return ans;
    }

    int countSmallEqual(int[][] mat, int val){
        int cnt = 0;
        int R = mat.length;
        for(int i=0;i<R;i++){
            cnt+=upperBound(mat[i] , val);
        }
        return cnt;
    }
    
    int median(int matrix[][], int R, int C) {
        // Code Here
        // TC - > O( log(array's max element - array's min element) * R * log(C)  )  , SC->O(1) ( where: R-> no.of rows, C-> no.of col's)
    
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<R;i++){
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high , matrix[i][C-1]);
        }
        int req = R*C/2;
        
        while(low<=high){
            int mid  = low + (high - low)/2;
            int smallEqual = countSmallEqual(matrix,mid);
            if(smallEqual <= req) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}