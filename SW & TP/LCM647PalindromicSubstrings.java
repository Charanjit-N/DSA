
// Brute Force: TC->O(n^2 * n = n^3) : generate All substrings(O(n^2)) and check palindrome or not(O(n))

// Optimal using Two pointer approach
// TC->O(n^2) , SC->O(1)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i=0;i<n;i++){
            // odd length palindromes
            int left = i, right = i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                cnt = cnt + 1;
                left--;
                right++;
            }

            // even length palindromes
            left = i;
            right = i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                cnt = cnt + 1;
                left--;
                right++;
            }
        }
        return cnt;   
    }
}