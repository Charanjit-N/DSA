class LCH76MinimumWindowSubstringThatContainsAllCharactersOfOtherGivenString {
    // boolean containsAllFromt(String a, String b){
    //     int n1 = a.length();
    //     int n2 = b.length();
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(int i=0;i<n2;i++){
    //         map.put(b.charAt(i),map.getOrDefault(b.charAt(i),0)+1);
    //     }
    //     for(int i=0; i<n1;i++){
    //         if(map.containsKey(a.charAt(i)) && map.get(a.charAt(i))!=0){
    //             map.put(a.charAt(i),map.get(a.charAt(i))-1);
    //         }
    //     }
    //     for(Integer freq : map.values()){
    //         if(freq !=0) return false;
    //     }
    //     return true;
    // }
    public String minWindow(String s, String t) {
        // Optimal: TC->O(2n1 + n2), SC->O(256)= O(1)
        int n1 = s.length();
        int n2 = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1, cnt = 0;
        int[] hashArr = new int[256];
        int l =0, r=0;
        for(int i=0;i<n2;i++){
            hashArr[t.charAt(i)]++;
        }
        while(r<n1){
            if(hashArr[s.charAt(r)]>0) { cnt++; } 
            hashArr[s.charAt(r)]--;
            while(cnt==n2){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    startIndex = l;
                }
                hashArr[s.charAt(l)]++;
                if(hashArr[s.charAt(l)] > 0) cnt--;
                l++;
            }
            r++;
        }
        if(startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLen);

        // Better : TC->O(n^2), SC->O(256) = O(1)
        // int minLen = Integer.MAX_VALUE;
        // int startIndex = -1;
        // int n1 = s.length(), n2 = t.length();
        // for(int i=0;i<n1;i++){
        //     int[] hashArr = new int[256];
        //     int cnt = 0;
        //     for(int j=0;j<n2;j++){
        //         hashArr[t.charAt(j)]++;
        //     }
        //     for(int j=i;j<n1;j++){
        //         if(hashArr[s.charAt(j)]>0) cnt = cnt+1;
        //         hashArr[s.charAt(j)]--;
        //         if(cnt == n2){
        //             if((j-i+1) < minLen){
        //                 minLen = j-i+1;
        //                 startIndex = i;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // if(startIndex == -1) return "";        
        // return s.substring(startIndex, startIndex + minLen);
        


        // Brute Force : TC->O(n^3) , SC-> O(n)
        // int n1 = s.length();
        // int n2 = t.length();
        // String ans = "";
        // int minLen = Integer.MAX_VALUE;

        // for(int i=0;i<n1;i++){
        //     String substr ="";
        //     for(int j=i;j<n1;j++){
        //         substr = substr +  s.charAt(j);
        //         System.out.println(substr +"---->"+containsAllFromt(substr,t));
        //         if(containsAllFromt(substr,t)){
        //             if(substr.length() < minLen){
        //                 ans = substr;
        //                 minLen = substr.length();
        //             }
        //         }
        //     }
        // }
        // return ans;
        
    }

    
}