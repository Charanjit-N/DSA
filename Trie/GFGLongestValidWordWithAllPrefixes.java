// Brute Force :  Sorting , Binary Search : TC-> O(n*k2*log n) , k->Avg length of a word in array ,SC ->O(1) 
class Solution {
    public String longestValidWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        // check each word
        for (String word : words) {
            boolean isValid = true;
            String prefix = "";
            // check all prefixes of the word
            for (char ch : word.toCharArray()) {
                prefix += ch;
                // if the prefix is not in the array
                // O(log n)
                if (Arrays.binarySearch(words, prefix) < 0) {  
                    isValid = false;
                    break;
                }
            }
            if (isValid && 
                (word.length() > result.length() || 
                (word.length() == result.length() && word.compareTo(result) < 0))) {
                result = word;
            }
        }
        return result;
    }
}



// Optimal : USing Trie
// TC ->O(n*k + n*k) = O(n*k) n-> string array length, k->Avg length of a word in array
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
    boolean checkIfAllPrefixesExist(String word){
        TrieNode nd =  root;
        for(int i=0;i<word.length();i++){
            char ch  = word.charAt(i);
            nd =  nd.children[ch-'a'];
            if(nd.isEndOfWord == false) return false;
        }
        return true;   
    }
}
class Solution {
    public String longestValidWord(String[] words) {
        // O(n * k) : k->Avg length of a word in words
        // inserting every word in words into Trie
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        // O(n * k) : k->Avg length of a word in words = T.C of checkIfAllPrefixesExist()
        int maxLen =  0;
        String ans = "";
        for(String word : words){
            if(trie.checkIfAllPrefixesExist(word) == true){
                if(word.length() >  maxLen){
                    maxLen = word.length();
                    ans =  word;
                }
                else if(word.length() ==  maxLen){
                    if(word.compareTo(ans) < 0){
                        ans =  word;
                    }
                }   
            }
        }
        return ans;
    }
}


