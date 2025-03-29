class LCM451SortStringInOrderOfCharacterFrequency {
    public String frequencySort(String s) {
        // TC->O(nlogn), SC->O(n)
        StringBuffer ans  = new StringBuffer();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> list = new ArrayList(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        for( char ch : list){
            int freq = map.get(ch);
            for(int i=1;i<=freq;i++) ans.append(ch);
        }
        return ans.toString();
        
        
    }
}