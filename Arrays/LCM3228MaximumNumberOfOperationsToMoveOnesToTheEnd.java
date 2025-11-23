// TC ->O(n)
class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int cnt=0;
        int prefixSum=0, ans =0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='1') cnt++;
            else {
                if(cnt != 0){
                    prefixSum += cnt;
                    ans += prefixSum;
                }
                cnt = 0;
            }
        }
        return ans;
    }
}