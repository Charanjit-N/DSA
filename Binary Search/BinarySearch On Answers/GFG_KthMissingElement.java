// TC->O(log n), SC->O(1)
class Solution {
    int KthMissingElement(int arr[], int k) {
        int n = arr.length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low+(high - low)/2;
            int missing = arr[mid] - (mid+arr[0]);
            if(missing<k) low = mid+1;
            else high = mid-1;

        }
        return high+arr[0]+k < arr[n-1] ? high+arr[0]+k :-1; 
    }
}
