class LCE338CountingBits {
    //TC→O(n*q) q: num of set bits in that number , SC→O(1)
    public int[] countBits(int n) {
        int[] ans =  new int[n+1];
        for(int i=0;i <=n ;i++){
            int cnt =0;
            int k = i;
            while(k>0){
                k = k & (k-1);
                cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
        
    }
}

// DP Approach (TC → O(n), SC→ O(n))
// => We observe a repeated pattern after every power of 2(2,4,8,16,....) . The bits to the right side of the most significant bit are the same, for example take 4 , from numbers 0 to 3 and 4 to 7 have the same rightmost two bits similarly the pattern repeats, So we can save repeated calculations. For finding the number of set bits for 6 we just see the number of set bits for 2 and add 1(for the new most significant bit).
class LCE338CountingBits {
    public int[] countBits(int n) {
        int[] dp =  new int[n+1];
        int sub = 1;
        for(int i=1;i<=n;i++){
            if(2*sub == i){
                sub = i;
            }
            dp[i] = dp[i-sub] +1;
        }
        return dp;
    }
}