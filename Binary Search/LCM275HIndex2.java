// TC -> O(logn)
class Solution {
    public int hIndex(int[] citations) {
       int n = citations.length;
        int low = 0 , high = n-1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2 ;
            if(citations[mid] < n-mid) low = mid + 1;
            else if(citations[mid] >= n-mid){
                ans = n-mid;
                high = mid - 1;
            }
        }
        return ans;
        
    }
}


// TC ->O(n)
class Solution {
    public int hIndex(int[] citations) {
        int h=0;
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]>h) h++;
            else return h;
        }
        return h;
    }
}