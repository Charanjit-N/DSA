class LCE205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] sIndex = new int[128];
        int[] tIndex =  new int[128];
        for(int i =0;i<len;i++){
            if(sIndex[s.charAt(i)] != tIndex[t.charAt(i)]){
                return false;
            }

            sIndex[s.charAt(i)] = i+1;
            tIndex[t.charAt(i)] = i+1;

        }
        return true;

        // Map<Character, Character> map = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char original = s.charAt(i);
        //     char replacement = t.charAt(i);

        //     if(!map.containsKey(original)){
        //         if(!map.containsValue(replacement)){
        //             map.put(original,replacement);
        //         }
        //         else{
        //             return false;
        //         }
        //     }
        //     else{
        //         if(map.get(original) != replacement){
        //             return false;
        //         }
        //     }
        // }
        // return true;
        
    }
}