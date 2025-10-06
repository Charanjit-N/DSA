
// TC --> O(n), SC-->O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String , Integer> map = new HashMap<>();
        int n = s.length();
        List<String> ans = new ArrayList<>();
        int l = 0;
        int r =  9;
        while(r<n){
            String sub = s.substring(l,r+1);
            map.put(sub, map.getOrDefault(sub,0)+1);
            l++;
            r++;
        }
        for(Map.Entry<String , Integer> x :  map.entrySet()){
            if(x.getValue() > 1) ans.add(x.getKey());
        }
        return ans;   
    }
}

// TC ->O(n) , SC->O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int n = s.length();
        int l=0;
        int r = 9;
        while(r < n) {
            String sub = s.substring(l, r+1);
            if (seen.contains(sub)) {            
                if (!repeated.contains(sub)) {       
                    ans.add(sub);
                }
                repeated.add(sub);
            }
            seen.add(sub);
            l++;
            r++;
        }
        return ans;
    }
}