// TC --> O(n + 26*(n+n)) = O(26*n) = O(n) (approx)
// SC -->O(n)
class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> s1 =  new HashSet();
        for(Character c : s.toCharArray()){
            s1.add(c);
        }
        int ans = 0;
        for(Character c :  s1){
            int i= -1;
            int j =0;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k) == c){
                    if(i == -1){
                        i = k;
                    }
                    j = k;
                }
            }
            Set<Character> s2 =  new HashSet<>();
            for(int k= i+1 ;k < j;k++){
                s2.add(s.charAt(k));
            }

            ans += s2.size();
        }
        return ans;
    }
}

// Little Optimization on Above
// TC ->O(n + 26*n) = O(26*n)=O(n), SC->O(n)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'a';
            if(first[ch] == -1){
                first[ch] = i;
            }
            last[ch] = i;
        }
        int ans = 0;
        for(int i=0;i<26;i++){

            if(first[i] == -1) {
                continue;
            }
            Set<Character> s2 =  new HashSet<>();
            for(int j= first[i]+1 ;j < last[i];j++){
                s2.add(s.charAt(j));
            }
            ans += s2.size();
        }
        return ans;
    }
}