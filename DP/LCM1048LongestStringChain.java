// Tabulation approach 
//  TC->O(n^2 * max length of string in words) + O(nlogn) :sorting, SC->O(n) : dp array.
class Solution {
    boolean check(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int x = 0, y=0;
        while(x<s1.length()){
            if(y<s2.length()  && s1.charAt(x) == s2.charAt(y)){
                x++;
                y++;
            }
            else{
                x++;
            }
        }
        if(x == s1.length() && y==s2.length()) return true;
        else return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = (int)-1e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i], words[j])){
                    dp[i] = Math.max(dp[i] , 1+dp[j]);
                }
            }
            max =  Math.max(max, dp[i]);
        }
        return max;
    }
}