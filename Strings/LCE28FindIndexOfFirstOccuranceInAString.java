// TC->O(len1 x len2)   len1->length of haystack, len2-> length of needle
class LCE28FindIndexOfFirstOccuranceInAString {   
    public int strStr(String haystack, String needle) {
        int i=0;
        boolean found = false;
        while(i<haystack.length()){
            int prev_i = i;
            int j=0;
            while(j<needle.length() && i<haystack.length()){
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
                else break;
            }
            if(j == needle.length()){
                found = true;
                break;
            }
        
           

            i=prev_i;
            i++;
            
        }
        return found==true ? i-needle.length() : -1;
        
    }
}


class LCE28FindIndexOfFirstOccuranceInAString {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}