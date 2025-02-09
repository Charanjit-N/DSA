
/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

*/


class LCH51NQueensProblem {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        findPossibilities(board,n,0,res);
        return res;
    }
    void findPossibilities(char[][] board, int n, int col,List<List<String>> res){
        if(col == n){
            res.add(Arrays.stream(board)
                          .map(String::new)
                          .toList());

            // (or) using construct method that is defined below
            // res.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafeToPlace(board,n,row,col)== true){
                board[row][col]= 'Q';
                findPossibilities(board, n , col+1 ,res);
                board[row][col] ='.';
            }
        }
    }

    boolean isSafeToPlace(char[][] board, int n , int row, int col){
        int duprow =row;
        int dupcol = col;

        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while(row<n && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}


// Optimization : Avoiding {isSafToPlace() -->TC:O(3n)} using Hashing
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        findPossibilities(board,n,0,res,leftRow,upperDiagonal,lowerDiagonal);
        return res;
    }
    void findPossibilities(char[][] board, int n, int col,List<List<String>> res,int[] leftRow,
    int[] upperDiagonal, int[] lowerDiagonal){
        if(col == n){
            res.add(Arrays.stream(board)
                          .map(String::new)
                          .toList());
            return;
        }
        for(int row=0;row<n;row++){
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                findPossibilities(board, n , col+1 ,res,leftRow, upperDiagonal,lowerDiagonal);
                board[row][col] ='.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}
