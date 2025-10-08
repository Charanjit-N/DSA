class TrieNode{
    TrieNode[] children;
    int cntEndWith;
    int cntPrefix;
    TrieNode(){
        children = new TrieNode[26];
        cntEndWith = 0;
        cntPrefix = 0;
    }
}

// All operations are O(len) , the len(string) on which the operation is called 
class TUFTrieAdvanceOperations{
    TrieNode root;
    public TUFTrieAdvanceOperations() {
        root = new TrieNode();

    }
    public void insert(String word) {
        TrieNode nd = root;
        for(int i=0;i<word.length();i++){
            char ch  = word.charAt(i);
            if(nd.children[ch-'a']== null){
                TrieNode  newNode = new TrieNode();
                nd.children[ch-'a'] = newNode;
            }
            nd =  nd.children[ch-'a'];
            nd.cntPrefix++;
        }
         nd.cntEndWith++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode nd =  root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(nd.children[ch-'a'] != null){
                nd =  nd.children[ch-'a'];
            }else{
                return 0;
            }
            
        }
        return nd.cntEndWith;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode nd =  root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(nd.children[ch-'a'] != null){
                nd =  nd.children[ch-'a'];
            }else{
                return 0;
            }
            
        }
        return nd.cntPrefix;
    }

    public void erase(String word) {
        TrieNode nd = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            nd = nd.children[ch-'a'];
            nd.cntPrefix--;
        }
        nd.cntEndWith--;
    }
    public static void main(String args[]){
        TUFTrieAdvanceOperations obj = new TUFTrieAdvanceOperations();
        obj.insert("apple");
        System.out.println(obj.countWordsEqualTo("apple"));  // return 1
        obj.insert("app");
        System.out.println(obj.countWordsStartingWith("app"));// return 2
        obj.erase("apple");
        System.out.println(obj.countWordsStartingWith("app"));   // return 1
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */