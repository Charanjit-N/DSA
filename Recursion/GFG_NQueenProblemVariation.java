
/*
The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.
Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
*/


Examples:

Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.
*/

class GFG_NQueenVariation {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[][] board = new int[n][n];
        
            
        int[] leftRow= new int[n];
        int[] lowerDiagonal= new int[2*n-1];
        int[] upperDiagonal= new int[2*n-1];
        findPossibilities(board,n,0,leftRow,upperDiagonal,lowerDiagonal,new ArrayList<>() , res);
        return res;
        // code here
    }
    void findPossibilities(int[][] board,int n, int col, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal,ArrayList<Integer> ls, ArrayList<ArrayList<Integer>> res){
        if(col == n){
            res.add(new ArrayList<>(ls));
        }
        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0){
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                ls.add(row+1);
                findPossibilities(board, n, col+1,leftRow,upperDiagonal,lowerDiagonal,ls , res);
                ls.remove(ls.size()-1);
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;
            }
        }
    }
}