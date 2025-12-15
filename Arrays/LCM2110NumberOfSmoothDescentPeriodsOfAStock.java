// TC --> O(N), SC-->O(1)
// No of subarrays form an array of length x = x * (x+1)/2
//No of subarrays form an array of length x except length 1 subarrays = [x * (x+1)/2] - x
class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = n;
        int l = 0, r= 1;
        while(r < n){
            if(prices[r] == prices[r-1]-1){
                if(r == n-1){
                    long x = r - l +1;
                    ans +=  x*(x+1)/2 -  x;
                }
                r++;
            }else{
                long x =  (r-1) - l +1;
                ans +=  x*(x+1)/2 -  x;
                l =r;
                r++;
            }
        }
        return ans;
    }
}