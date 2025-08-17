// TC ->O(log n/2) = log(n) , SC->O(1)
class Solution {
    public long floorSqrt(long n) {
        if(n==1) return 1;
        long low =  1;
        long high = n/2;
        long ans = 0;
        while(low <= high){
            long mid  = low + (high - low)/2;
            if(mid*mid <= n){
                ans =  mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
}