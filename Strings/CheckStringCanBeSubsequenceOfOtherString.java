// TC -> worst case O(n = len(s))
class Solution {
    boolean canBeSubseq(String s, String x) {
        int m = s.length();
        int n = x.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == x.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}
