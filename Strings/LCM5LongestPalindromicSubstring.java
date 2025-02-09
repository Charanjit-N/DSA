class LCM5LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        // Optimal : take each character of the string and assume it as the middle of the palindrome and expan outwards, handle even length and odd length palindromes seperatley
        // TC->O(n^2) , SC->O(1)
        String ans ="";
        int maxLen  = 0;
        for(int i=0;i<s.length();i++){
            int left =i;
            int right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if((right-left+1) > maxLen){
                    maxLen = right-left+1;
                    ans = s.substring(left,right+1);
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if((right-left+1) > maxLen){
                    maxLen = right-left+1;
                    ans = s.substring(left,right+1);
                }
                left--;
                right++;
            }
        }
        return ans;



        // //Brute : Calculating all Substrings and finding if palindrome (TC->O(n^3))
        // int len = s.length();
        // StringBuffer ans = new StringBuffer();
        // // String ans2 = "";    String also works
        // int maxLen =  0;
        // for(int i =0 ;i<len;i++){
        //     for(int j=i;j<len;j++){
        //         String substr  = s.substring(i,j+1);
        //         if(isPalindrome(substr)){
        //             if(substr.length() >  maxLen){
        //                 maxLen = substr.length();
        //                 ans.setLength(0);
        //                 ans.append(substr);
                    
        //                 // ans2 = substr;
        //             }
        //         }
        //     }
        // }
        // return ans.toString();  //ans2.toString();
        
    }
    
    // boolean isPalindrome(String str){
    //     int left = 0,right = str.length()-1;
    //     while(left<right){
    //         if(str.charAt(left) != str.charAt(right)) return false;
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
}