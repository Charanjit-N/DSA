// TC -> O(n^3) , SC->O(n^3)
class Solution {
    public static int countDistinctSubstring(String st) {
        Set<String> set = new HashSet<>();
        int n = st.length();
        for(int i=0;i<n;i++){
            String sub ="";
            for(int j=i;j<n;j++){
                sub +=  st.charAt(j);
                set.add(sub);
            }
        }
        return set.size()+1;
    }
}

//Optimal: using Trie: TC ->O(n^2) 
class TrieNode{
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
        
    }
}
class GfG {
    public static int countDistinctSubstring(String st) {
        TrieNode root = new TrieNode();
        int n = st.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            TrieNode nd = root;
            for(int j=i;j<n;j++){
                char ch = st.charAt(j);
                if(nd.children[ch-'a'] == null){
                    TrieNode  newNode =  new TrieNode();
                    nd.children[ch-'a'] = newNode;
                    cnt++;
                }
                nd =  nd.children[ch-'a'];
            }
        }
        return cnt+1;
    }
}