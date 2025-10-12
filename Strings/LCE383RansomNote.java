// TC -> O(n), SC->O(1)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() >  magazine.length()) return false;
        int[] hash = new int[26];
        for(int i=0;i<magazine.length();i++){
            hash[magazine.charAt(i)-'a']++;
        }

        for(int i=0;i<ransomNote.length();i++ ){
            hash[ransomNote.charAt(i)-'a']--;
            if(hash[ransomNote.charAt(i)-'a'] < 0) return false;
        }
        return true;
    }
}