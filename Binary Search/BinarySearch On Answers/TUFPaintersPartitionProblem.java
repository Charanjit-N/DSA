// TC->O(n * log(sum of elements in arr - max element in arr))
class Solution {
    int countPainters(int[] arr, int maxTime){
        int noOfPainters = 1; 
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] > maxTime){
                noOfPainters++;
                sum = arr[i];
            }
            else{
                sum += arr[i];
            }
        }
        return noOfPainters;
    }
    public int paint(int A, int B, int[] C) {
        int low = 0,high = 0;
        for(int i=0;i<C.length;i++){
            low = Math.max(low, C[i]);
            high += C[i];
        }
        low = low* B;
        high = high *B;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int painters = countPainters(C,mid/B);
            if(painters > A)  low=mid+1;
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}

