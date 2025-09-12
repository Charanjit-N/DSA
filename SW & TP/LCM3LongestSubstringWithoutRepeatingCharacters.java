class LCM3LongestSubstringWithoutRepeatingCharacters {
    // boolean haveRepeatedCharacters(String str){
    //     int[] hashArr = new int[256];
    //     for(int i=0;i<str.length();i++){
    //         if(hashArr[str.charAt(i)]!=0) return true;
    //         hashArr[str.charAt(i)]++;
    //     }
    //     return false;
    // }
    public int lengthOfLongestSubstring(String s) {

        // Optimal :(using two pointer and sliding windoow combined) 
        // TC-> O(n), SC->O(1)
        int[] hashArr = new int[256];   
        Arrays.fill(hashArr,-1);           // tc->O(n)
        int len = s.length();
        int l =0, r=0;
        int maxLen =0;
        while(r<len){                           // tc->O(n)
            if(hashArr[s.charAt(r)]!=-1){
                if( hashArr[s.charAt(r)] >= l ) { l = hashArr[s.charAt(r)] + 1; } 
                
            }

            int substrLen = r-l+1;
            maxLen = Math.max(maxLen , substrLen);

            hashArr[s.charAt(r)] = r;
            r++;
        }
        return maxLen;

        // Better : TC->O(n^2) and SC->O(1) {using same hash array of size 256 units again and again}
        // int len = s.length();
        // System.out.println(len);
        // int maxLen = 0;
        // for(int i=0;i<len;i++){
        //     int[] hashArr = new int[256];
        //     for(int j=i;j<len;j++){
        //         if(hashArr[s.charAt(j)]!=0) break;
        //         maxLen = Math.max(maxLen, (j-i+1));
        //         hashArr[s.charAt(j)]=1;
        //     }   
        // }
        // return maxLen;
        
        // Brute: TC->O(n^3) , SC->O(1) 
        // int len = s.length();
        // int maxLen = 0;
        // for(int i=0;i<len;i++){
        //     String substr ="";
        //     for(int j=i;j<len;j++){
        //         substr+=s.charAt(j);
        //         if(!haveRepeatedCharacters(substr)){
        //             maxLen = Math.max(maxLen,substr.length());
        //         }
        //     }
        // }
        // return maxLen;
        
    }
}