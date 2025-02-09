/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]

Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
*/

// Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n^2 board, we have 9 possibilities.

class LCH37SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c ='1' ;c<='9';c++){
                        if(isSafe(board, i,j,c)== true){
                            board[i][j] = c;
                            if(solve(board)== true) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;      //If we no get any c (1 to 9) that is safe to fill then our possibility so far is wrong so remove(board[i][j]='.') and back track 
                }
            }
        }
        return true;    // No '.' left in board so filled all return true
    }

    boolean isSafe(char[][] board, int row , int col , char c){
        for(int i=0;i<9;i++){
            if(board[row][i]==c) return false;
            
            if(board[i][col]==c) return false;

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;

        }
        return true;
    }
}