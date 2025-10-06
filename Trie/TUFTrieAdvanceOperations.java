class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class TrieImplementation{
    
    TrieNode root;
    TrieImplementation() {
        root =  new TrieNode();
    }

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

    	
    //O(n) Here n is the length of the string searched
    boolean isPrefix(String key){   // startsWith(String key)
        TrieNode nd = root;
        for(int i=0;i<key.length();i++){
            char ch  = key.charAt(i);
            if(nd.children[ch-'a'] == null) return false;
            nd = nd.children[ch-'a']; 
        }
        return true;

    }

    public static void main(String[] args)
    {
        TrieImplementation trie = new TrieImplementation();
        String[] arr = {"and", "ant", "do", "dad"};
        for (String s : arr) {
            trie.insert(s);
        }
        String[] searchKeys = { "do", "gee", "bat" };  
        // true false false

        for (String s : searchKeys) {
            if (trie.search(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
        System.out.println();
        String[] prefixKeys = { "ge", "ba", "do", "de","an" };  
        // false false true false true
        for (String s : prefixKeys) {
            if (trie.isPrefix(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
    
}