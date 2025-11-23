// TC -->O(n)
class Solution {
    public int numSub(String s) {
        int mod = (int)1e9 + 7;
        long ans = 0;
        long consOnes = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                consOnes++;
            }
            else{
                ans += consOnes * (consOnes + 1) / 2;
                consOnes = 0;

            }
            
        }
        ans += consOnes * (consOnes + 1) / 2 ;
        return (int)(ans%mod);
    }
}

