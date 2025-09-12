class LCM187RepeatedDNASequences {
    // TC --> O(n), SC-->O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        int l=0, r= 9;
        HashMap<String , Integer> map = new HashMap<>();
        while(r<s.length()){
            String sub = s.substring(l,r+1);
            map.put(sub, map.getOrDefault(sub,0)+1);
            l++;
            r++;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String str : map.keySet()){
            if(map.get(str) > 1) { ans.add(str);}
        }
        return ans;
    }
}