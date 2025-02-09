class LCM424ReplaceToGetLongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        // Optimal 2 : TC->O(n) , SC-> O(26) = O(1)(approximation) =>{constant space complexity}
        int n =s.length();
        int left=0,right=0;
        int maxLen =0;
        int[] hashArr = new int[26];
        int maxFreq = 0;
        while(right < n){
            hashArr[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq, hashArr[s.charAt(right)-'A']);
            if( (right-left+1) - maxFreq > k){
                hashArr[s.charAt(left)-'A']--;
                left++;
            }
            // No need for updating the maxFreq take some example and dry run you get it.
            if((right-left+1) - maxFreq <= k){
                maxLen = Math.max(maxLen , right-left+1); 
            }
            right++;
        }
        return maxLen;

        // Optimal 1 : TC->O((n+n)*26) =O((2n)*26) = O(52*n) = O(n) (approximation for large values of n)
        // SC-> O(26) = O(1)(approximation) =>{constant space complexity}
        // int n =s.length();
        // int left=0,right=0;
        // int maxLen =0;
        // int[] hashArr = new int[26];
        // int maxFreq = 0;
        // while(right < n){
        //     hashArr[s.charAt(right)-'A']++;
        //     maxFreq = Math.max(maxFreq, hashArr[s.charAt(right)-'A']);
        //    while( (right-left+1) - maxFreq > k){
        //         hashArr[s.charAt(left)-'A']--;

        //         maxFreq = 0;
        //         for(int x=0;x<26;x++){  // T.C->O(26) 
        //             maxFreq = Math.max(maxFreq , hashArr[x]);
        //         }
                
        //         left++;
        //     }
        //     if((right-left+1) - maxFreq <= k){
        //         maxLen = Math.max(maxLen , right-left+1);
        //     }
        //     right++;
        // }
        // return maxLen;



        // Better : TC->O(N^2) , SC-> O(26) = O(1)(approximation) =>{constant space complexity}
        // int n = s.length();
        // int maxLen = 0;
        // for(int i=0;i<n;i++){
        //     int[] hashArr = new int[26];
        //     int maxFreq = 0;
        //     for(int j=i;j<n;j++){
        //         hashArr[s.charAt(j)-'A']++;
        //         maxFreq = Math.max(maxFreq,hashArr[s.charAt(j)-'A']);
        //         int changeNeeded = (j-i+1) - maxFreq;
        //         if(changeNeeded <= k){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return maxLen;
        
    }
}