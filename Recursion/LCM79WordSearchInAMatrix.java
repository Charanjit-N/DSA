
/* Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*/

//TC-> O(r*c*(4^(len of word)))

class LCM79WordSearchInAMatrix {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    System.out.println(i+" "+j);
                    if(findWord(board, word, 0,i,j) == true) return true;
                }
            }
        }
        return false;
        
    }
    boolean findWord(char[][] board, String word, int index, int r, int c){
        if(index==word.length()) return true;
        if(r<0 || c<0 || r==board.length || c==board[0].length || board[r][c]!=word.charAt(index)|| board[r][c]=='#'){
            return false;
        }
        char ch =board[r][c];
        board[r][c] ='#';

        if(findWord(board, word, index+1,r,c+1) == true) return true;
        if(findWord(board, word, index+1,r,c-1) == true) return true;
        if(findWord(board, word, index+1,r+1,c) == true) return true;
        if(findWord(board, word, index+1,r-1,c) == true) return true;
        
        // boolean right = findWord(board, word, index+1,r,c+1); 
        // boolean left = findWord(board, word, index+1,r,c-1); 
        // boolean top = findWord(board, word, index+1,r-1,c); 
        // boolean bottom = findWord(board, word, index+1,r+1,c); 

        board[r][c] = ch;
 
        return false;
        // return top||bottom||left||right;
        
    }
}