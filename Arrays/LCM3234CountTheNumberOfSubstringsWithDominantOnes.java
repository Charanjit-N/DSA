// TC -> O(n * sqrt(n))
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] nextZero = new int[n];
        nextZero[n-1] =  n;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i+1)=='0'){
                nextZero[i] = i+1;
            }else{
                nextZero[i] = nextZero[i+1];
            }
        }
        int res = 0 ;
        for(int i=0;i<n;i++){
            int zeroCnt =  (s.charAt(i)=='0') ? 1 : 0;
            int j= i;
            while(zeroCnt * zeroCnt <= n){
                int next_zero = nextZero[j];
                int oneCnt =  (next_zero - i) - zeroCnt;
                if(oneCnt >= zeroCnt*zeroCnt){
                    res +=  Math.min( next_zero - j,  oneCnt- (zeroCnt*zeroCnt) + 1 );
                }
                j = next_zero;
                zeroCnt++;

                if(j == n)  break;
                
            }
        }
        return res;
    }
}



// TC ->O(n * sqrt(n)) almost all cases
// but O(n^2) in worst case
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[][] cnts =  new int[n][2];
        int cnt0 = 0, cnt1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') cnt0++;
            else cnt1++;
            cnts[i][0] =  cnt0;
            cnts[i][1] = cnt1;
        }
        for(int i=0;i<n;i++){
            for(int j =i;j<n;j++){
                cnt0 =  cnts[j][0] - (i-1>=0 ? cnts[i-1][0] : 0) ;
                cnt1 =  cnts[j][1] -  (i-1>=0 ? cnts[i-1][1] : 0);
                if(cnt1 < cnt0*cnt0){
                    j += (cnt0*cnt0 -  cnt1) - 1;
                }
                else if(cnt0*cnt0 == cnt1) ans++;
                else{    // cont0*cnt0 < cnt1
                    ans++;
                    int shift =  (int)Math.sqrt(cnt1) -  cnt0;
                    int nextj =  j + shift;
                    if(nextj >= n){
                        ans += n-1-j;
                        break;
                    }
                    else{
                        ans +=  shift;
                    }
                    j= nextj;
                }      
            }
        }
        return ans;
    }
}