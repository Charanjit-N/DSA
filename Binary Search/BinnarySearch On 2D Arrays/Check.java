

//User function Template for Java
import java.util.*;
class Check {
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
        System.out.print("value = "+val+"-->");
        for(int i=0;i<R;i++){
            int up = upperBound(mat[i] , val);
            System.out.print(up+" ");
            cnt += up;
        }
        System.out.println();
        return cnt;
    }
    int median(int matrix[][], int R, int C) {
        // code here        
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
    public static void main(String args[]){
        Check obj = new Check();
        int[][] arr = {{1,3,5},{2,6,9},{3,6,9}};
        System.out.println(obj.median(arr,3,3));
    }
}