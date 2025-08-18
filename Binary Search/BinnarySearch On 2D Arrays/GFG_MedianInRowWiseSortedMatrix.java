// Optimal : TC→O(m + log(max-min)*m*logn) = O(log(max-min)*m*logn), SC-->O(1)
class Solution {
    int upperBound(int[] arr, int val){  // log(n)
        int ans = arr.length; // here its # cols
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
        for(int i=0;i<R;i++){  // m*log(n)
            cnt+=upperBound(mat[i] , val);
        }
        return cnt;
    }
    int median(int matrix[][], int R, int C) {      
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<R;i++){   // O(m)
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high , matrix[i][C-1]);
        }
        int req = R*C/2;
        
        while(low<=high){ //O(log(max-min))
            int mid  = low + (high - low)/2;
            int smallEqual = countSmallEqual(matrix,mid);
            if(smallEqual <= req) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}