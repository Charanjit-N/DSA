// TC ->O(logm * logn)
class Solution {
    public int calPow(int a, int n) {
        int ans = 1;
        while(n!=0)
        {
            if(n%2==1){
                ans = ans*a;
                n--;
            }   
            else{
                a = a*a;
                n = n/2;
            }
        }
        return ans;
    }
    public int nthRoot(int n, int m) {
        int low  = 1;
        int high = m;
        while(low <= high){
            int mid =  low + (high - low)/2;
            int val = calPow(mid,n);
            if(val == m) return mid;
            else if(val < m) low =  mid+1;
            else high = mid-1;
        }
        return -1;
    }
}

