// Brute Force:
// TC -> O(W * M * N * 4^L), SC->(M*N  + L) {W : number of words in given string[] array , L : avg length of word}
class Solution {
    boolean dfs(int index , int r, int c,char[][] board, String word){
       if(index==word.length()) return true;
        if(r<0 || c<0 || r==board.length || c==board[0].length || board[r][c]!=word.charAt(index)|| board[r][c]=='#'){
            return false;
        }
        char ch =board[r][c];
        board[r][c] ='#';
 
        boolean right = dfs(index+1,r,c+1,board,word); 
        boolean left = dfs(index+1,r,c-1,board,word); 
        boolean top = dfs(index+1,r-1,c,board,word); 
        boolean bottom = dfs(index+1,r+1,c,board,word); 

        board[r][c] = ch;
 
       return top||bottom||left||right;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        Set<String> set = new HashSet<>();
        
        for(String w : words){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    char[][] arr =  board;
                    if(arr[i][j] == w.charAt(0)){
                        if(dfs(0,i,j,arr,w) == true) set.add(w);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}


// Optimal (Using Trie) : We avoid some dfs calls
class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    String word;
    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord =  false;
        word ="";
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root =  new TrieNode();
    }
    void insert(String str){
        TrieNode nd =  root;
        for(int i=0;i<str.length();i++){
            char ch  = str.charAt(i);
            if(nd.children[ch-'a'] == null){
                TrieNode newNode = new TrieNode();
                nd.children[ch-'a'] = newNode;
            }
            nd =  nd.children[ch-'a'];
        }
        nd.isEndOfWord =  true;
        nd.word =  str;
    }
    
}
class Solution {
    void dfs(char[][] board, TrieNode node, int r , int c,List<String> ans){
       
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]=='#'){
            return;
        }

        if(node.children[board[r][c] - 'a'] == null ){
            return;
        }

        node =  node.children[board[r][c] - 'a'];
        if(node.isEndOfWord == true){
            ans.add(node.word);
            node.isEndOfWord = false;
        }
       
       char temp = board[r][c];
       board[r][c] = '#';
    
       dfs(board,node, r,c+1,ans); 
        dfs(board, node, r,c-1,ans); 
        dfs(board, node, r-1,c,ans); 
        dfs(board, node, r+1,c,ans); 

        board[r][c] = temp;
 
      
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        TrieNode root =  trie.root;

        int m = board.length;
        int n = board[0].length;

        List<String> ans =  new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char startingLetter =  board[i][j];
                if(root.children[startingLetter-'a'] != null){
                    dfs(board, root, i,j,ans);
                }  
                
            }
        }
        return ans;
    }
}