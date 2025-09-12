class Solution {
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    public String reverseVowels(String s) {
        int n = s.length();
        int l  = 0;
        int r = n-1;
        char[] sarr =  s.toCharArray();
        while(l<r){
            boolean lvowel = isVowel(sarr[l]);
            boolean rvowel = isVowel(sarr[r]);
            if(lvowel == true && rvowel == true){
                char temp = sarr[l];
                sarr[l] = sarr[r];
                sarr[r] =  temp;
                l++;
                r--;
            }
            else if(lvowel == false){
                l++;
            }
            else if(rvowel == false){
                r--;
            }
        }
        return new String(sarr);
    }
}