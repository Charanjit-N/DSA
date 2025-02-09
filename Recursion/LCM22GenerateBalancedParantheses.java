 /*
        The no of combinations of well-formed parentheses from a given n pairs of parentheses can
        be calculated by nth Number in the "Catalan Numbers sequence" which is given by:
                                 Cn = (2n)! / [(n+1)! * n!]  .
        ex : For n = 3 => Cn = 5 => Possible expressions are ((())), ()(()), ()()(), (())(), (()())
         Each expression is of length 2*n here 6.
*/

class LCM22GenerateBalancedParantheses{

    // Brute Force
    // boolean isValidParentheses(String str){    // TC->O(2n)
    //     int cnt = 0;
    //     for(int i=0;i<str.length();i++){
    //         if(str.charAt(i)=='('){
    //             cnt++;
    //         }
    //         else{
    //             cnt--;
    //         }
    //         if(cnt<0) return false;
    //     } 
    //     return cnt==0 ? true:false;
    // }
    // void createParethesis(String str, int n , List<String> res){
    //     if(str.length()==2*n){
    //         if(isValidParentheses(str)){
    //             res.add(str);
    //         }
    //         return;
    //     }
    //     createParethesis(str+"(",n,res);
    //     createParethesis(str+")",n,res);
    // }
     
    // Better Approach 1
    // void createParethesis(int openCount, int closeCount, int n, List<String> ls, List<String> res) {
    //     if (openCount >= n && closeCount >= n) {
    //         String wellFormedParentheses = String.join("", ls);
    //         res.add(wellFormedParentheses);
    //     }
    //     if (openCount < n) {
    //         ls.add("(");
    //         createParethesis(openCount+1, closeCount,n, ls, res);
    //         ls.remove(ls.size() - 1);
    //     }
    //     if (closeCount < openCount) {
    //         ls.add(")");
    //         createParethesis(openCount, closeCount + 1,n, ls, res);
    //         ls.remove(ls.size() - 1);
    //     }
    // }


    // Better Approach 2 
    void createParethesis(int openCount, int closeCount,int n, String str,List<String> res ){
        if (openCount >= n && closeCount >= n){
            res.add(str);
            return;
        }
        if(openCount < n){
             
            createParethesis(openCount+1, closeCount, n, str+"(", res);
        }
        if(closeCount < openCount){
            createParethesis(openCount, closeCount+1, n, str+")", res);
        }
    }


    public List<String> generateParenthesis(int n) {

        /* Brute Force:
           {n-> no of pairs}
           TC->O( [2^(2n)] * (2n) )   {extra 2n : we are checking using isValidParentheses()}   
           SC->O(2n + k*(2n)) {2n-> recursion stack space[depth of the recursion tree] ;
                               k*(2n)-> list "res" to return the output. Where k no.of possible
                               well formed combinations(see above regarding catalan numbers).Each string in res list is of length 2n.  }
            -> Ignored string space in calculation of above Space complexity

        */
        // List<String> res = new ArrayList<>();
        // createParethesis("",n,res);
        // return res;

        //----------------------------------------------------------------------------------------------------
        /* Better Approach 1 : 
           {n-> no of pairs}
           TC->O(2^(2n))       
           SC->O(2n + k*(2n)) {2n-> recursion stack space[depth of the recursion tree] ;
                               k*(2n)-> list "res" to return the output. Where k no.of possible
                               well formed combinations(see above regarding catalan numbers).Each string in res list is of length 2n. }
            -> Ignored list "ls" space in calculation of above Space complexity
        */ 
        // List<String> res = new ArrayList<>();
        // List<String> ls = new ArrayList<>();
        // createParethesis(0, 0,n,ls, res);
        // return res;

        //----------------------------------------------------------------------------------------------------
        /* Better Approach 2 : Directly using string in place of List<String> ls
           {n-> no of pairs}
           TC->O(2^(2n))     
           SC->O(2n + k*(2n)) {2n-> recursion stack space[depth of the recursion tree] ;
                               k*(2n)-> list "res" to return the output. Where k no.of possible
                               well formed combinations(see above regarding catalan numbers).Each string in res list is of length 2n. }
            -> Ignored string space in calculation of above Space complexity
        */
        List<String> res = new ArrayList<>();
        createParethesis(0,0,n,"",res);
        return res;


       
        
    }
}