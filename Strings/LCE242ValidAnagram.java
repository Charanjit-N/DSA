class LCE242ValidAnagram {
    // String SortString(String str)
    //     {
    //         char c[] = str.toCharArray();
    //         Arrays.sort(c);
    //         return new String(c);
    //     }
    public boolean isAnagram(String s, String t) {
        // Brute Sorting: T.C ->  O(nlogn) , SC->O(1)
        // if (s.length() != t.length()) return false;
    
        // s = SortString(s);
        // t = SortString(t);
    
        // for (int i = 0; i < s.length(); i++)
        // {
        //     if (s.charAt(i) != t.charAt(i)) return false;
        // }
        // return true;

        // Optimal :  With hashing frequencies TC->O(n), SC->O(1) as array of 26 length is fixed ans constant space complexity.
        if (s.length() != t.length())
        return false;
    
        int[] hashArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hashArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hashArray[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hashArray[i] != 0)
                return false;
        }
        return true;
        
    }
}