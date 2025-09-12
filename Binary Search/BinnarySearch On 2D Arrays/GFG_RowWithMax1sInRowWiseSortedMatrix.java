// TC ->O(m * logn), SC->O(1)
class Solution {
    int firstOccuranceOfOne(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(arr[mid]==1){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int rowWithMax1s(int arr[][]) {
        int m= arr.length;
        int n = arr[0].length;
        int maxRow = -1;
        int minfc = n;
        for(int i=0;i<m;i++){
            int fc =  firstOccuranceOfOne(arr[i]);
            if(fc != -1 && fc < minfc){
                minfc = fc;
                maxRow = i;
                
            }
        }
        return maxRow;
    }
}