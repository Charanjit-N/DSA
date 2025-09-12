// TC -> O(n* logn + n*logn) = O(n*logn)
class Solution {
    int find(int[] arr, int dis){
        int cnt = 1;
        int prev =  arr[0];
        for(int i=1;i<arr.length;i++){
            int diff =  arr[i]-prev;
            if(diff >= dis){
                cnt++;
                prev =  arr[i];
            }
        }
        return cnt;
    }
    public int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low =  1;
        int high = stalls[n-1] - stalls[0];
        int ans =-1;
        while(low <= high){
            int mid =  low + (high - low)/2;
            int cnt = find(stalls,mid);
            if(cnt >= k) {
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
