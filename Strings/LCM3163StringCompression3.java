class LCM3163StringCompression3{
    public String compressedString(String word) {
        // TC -> O(n), SC->O(1)
        String comp = "";
        int len = word.length();
        int i = 0;
        while(i < len) {
            int cnt = 0;
            char ch   = word.charAt(i);
            while(i < len && cnt < 9 && word.charAt(i) == ch) {
                cnt++;
                i++;
            }
            comp += cnt;
            comp += ch;
        }
        return comp;


        // Method 2
        String comp ="";
        int len = word.length();
        if(len == 1) return "1"+word;
        int l=0, r=1;
        while(r<len){
            if(word.charAt(l)==word.charAt(r) && (r-l)<9){
                r++;
            }
            else{
                comp += (r-l) ;
                comp += word.charAt(l);
                // System.out.println(comp);
                l = r;
            }
            if(r==len){
                comp += (r-l) ;
                comp += word.charAt(l);
                // System.out.println(comp);
            }
        }
        return comp;

        
    }
}
