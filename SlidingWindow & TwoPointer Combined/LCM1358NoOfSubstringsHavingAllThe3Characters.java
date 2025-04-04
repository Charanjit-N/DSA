class LCM1358NoOfSubstringsHavingAllThe3Characters {
    
    public int numberOfSubstrings(String s) {
        
        // Optimal  : Sliding Window Approach TC->O(n), SC->O(1)
        int cnt = 0;
        int left=0,right=0,n=s.length();
        int[] hash = new int[3];
        while(right<n){
            hash[s.charAt(right)-'a']++;
            while(hash[0]>0 && hash[1]>0 && hash[2]>0){
                cnt = cnt + n-right;
                hash[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return cnt;


        // Other Optimal : Storing near by indices that form a valid window i.e., (at least one a & b & c) 
        // TC-> O(n) , SC->O(1) 
        int n = s.length();
        int[] lastSeenIndex = new int[3];
        Arrays.fill(lastSeenIndex,-1); // O(n)   
        int cnt = 0;
    
        for(int i=0;i<n;i++){   // O(n)
            lastSeenIndex[s.charAt(i)-'a'] = i;
            
            if(lastSeenIndex[0]!=-1  && lastSeenIndex[1]!=-1  && lastSeenIndex[2]!=-1){
                cnt = cnt + ( 1 + Math.min(lastSeenIndex[0],Math.min(lastSeenIndex[1],lastSeenIndex[2])) );
            }
        }
        return cnt;

        //Brute Force 2 (little optimization) : TC->O(N^2) , SC->O(1);
        int n = s.length();
        int cnt =0;
        for(int i=0;i<n;i++){
            int[] hashArr = new int[3];
            for(int j=i;j<n;j++ ){
                hashArr[s.charAt(j)-'a'] = 1;
                if(hashArr[0]+hashArr[1]+hashArr[2]==3){
                    cnt = cnt + (n-j);
                    break;
                }
            }
        }
        return cnt; 


        //Brute Force 1 : TC->O(N^2) , SC->O(1);
        int n = s.length();
        int cnt =0;
        for(int i=0;i<n;i++){
            int[] hashArr = new int[3];
            for(int j=i;j<n;j++ ){
                hashArr[s.charAt(j)-'a'] = 1;
                if(hashArr[0]+hashArr[1]+hashArr[2]==3){
                    cnt++;
                }
            }
        }
        return cnt; 
        
    }
}