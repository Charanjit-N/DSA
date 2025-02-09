class LCM1781SumOfBeautiesOfAllSubstringsOfString {
    // int calculateBeauty(String str){
    //     int[] hashArray = new int[26];
    //     for(int i=0;i<str.length();i++){
    //         hashArray[str.charAt(i)-'a']++;
    //     }
    //     int maxFreq = Integer.MIN_VALUE;
    //     int minFreq=Integer.MAX_VALUE;
    //     for(int i=0;i<hashArray.length;i++){
    //         maxFreq = Math.max(maxFreq,hashArray[i]);
    //         if(hashArray[i]>0) minFreq = Math.min(minFreq,hashArray[i]);
    //     }
    //     return maxFreq-minFreq;
    // }
    int calBeauty(int[] freq){
        int maxFreq = Integer.MIN_VALUE;
        int  minFreq = Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                maxFreq = Math.max(maxFreq, freq[i]);
                minFreq = Math.min(minFreq , freq[i]);
            }
        }
        return maxFreq - minFreq;
    }
    public int beautySum(String s) {
        // TC->O(n^2) , SC->O(n)
        int len = s.length();
        int ans = 0;
        for(int size=3;size<=len;size++){
            int i = 0;
            int j = size-1;
            int[] freq = new int[26];
            for(int k=i ;k<=j;k++){
                freq[s.charAt(k)-'a']++;
            }
            ans += calBeauty(freq);
            j++;
            while(j<len){
                freq[s.charAt(j) - 'a']++;
                freq[s.charAt(i) - 'a']--;
                ans+=calBeauty(freq);
                j++;
                i++;
            }
        }
        return ans;
        // Brute Force : Calculating all the substrings and calculating the sum of beauty if >0;
        // TC - >O(n^3) : Time Limit Exceed
        // int sum = 0;
        // int len = s.length();
        // for(int i=0;i<len;i++){
        //     for(int j=i;j<len;j++){
        //         int substrBeauty = calculateBeauty(s.substring(i,j+1));
        //         if(substrBeauty > 0) sum += substrBeauty;
        //     }
        // }
        // return sum;
    }
    
}