class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
class Trie{
    
    TrieNode root;
    Trie() {
        root =  new TrieNode();
    }

    // Inserts word into Trie
    // O(n) Here n is the length of the string inserted
    void insert(String word ){
        TrieNode nd = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(nd.children[ch-'a'] == null){
                TrieNode newNode = new TrieNode();
                nd.children[ch-'a'] = newNode;
            }
            nd = nd.children[ch-'a'];
        }
        nd.isEndOfWord = true;
    }

    // Check if given word exixts in the Trie
    // O(n) Here n is the length of the string searched
    boolean search(String word){
        TrieNode nd = root;
        for(int i=0;i<word.length();i++){
            char ch  = word.charAt(i);
            if(nd.children[ch-'a'] == null) return false;
            nd = nd.children[ch-'a']; 
        }
        return nd.isEndOfWord;
    }

    // Check is there i any word in Trie that starts with the given prefix    	
    //O(n) Here n is the length of the string searched
    boolean startsWith(String prefix){   
        TrieNode nd = root;
        for(int i=0;i<prefix.length();i++){
            char ch  = prefix.charAt(i);
            if(nd.children[ch-'a'] == null) return false;
            nd = nd.children[ch-'a']; 
        }
        return true;

    }

    public static void main(String[] args)
    {
        Trie obj = new Trie();
        String[] arr = {"and", "ant", "do", "dad"};
        for (String s : arr) {
            obj.insert(s);
        }
        String[] searchKeys = { "do", "gee", "bat" };  
        // true false false

        for (String s : searchKeys) {
            if (obj.search(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
        System.out.println();
        String[] prefixKeys = { "ge", "ba", "do", "de","an" };  
        // false false true false true
        for (String s : prefixKeys) {
            if (obj.startsWith(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
    
}