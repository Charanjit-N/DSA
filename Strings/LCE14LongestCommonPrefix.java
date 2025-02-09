class LCE14LongestCommonPrefix{
    // TC-> O(nlogn + M)  , SC-> O(1)
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);    // O(nlogn)
        int n = strs.length;
        String first = strs[0];
        String last = strs[n-1];
        int idx=0;
        while(idx < Math.min(first.length(),last.length())){       // O(m)
            if(first.charAt(idx)==last.charAt(idx)){
                idx++;
            }
            else{
                break;
            }
        }
        return first.substring(0,idx);



    // TC -> O(n * k) k->length of first string in array, SC-> O(1)

    // boolean check(String strs [], char ch, int idx)
    // {
    //     for( int i=1; i<strs.length; i++)
    //     {
    //         if(idx >= strs[i].length() || strs[i].charAt(idx)!=ch)return false;
    //     }
    //     return true;
    // }
    // public String longestCommonPrefix(String[] strs) {
    //     String ans="";
    //     for( int i=0; i<strs[0].length(); i++){
    //         char ch = strs[0].charAt(i);
    //         if(check(strs, ch , i)){
    //             ans+=ch;
    //         }else{
    //             break;
    //         }
    //     }
    //     return ans.length() > 0 ? ans : "";
 

        
    }
}