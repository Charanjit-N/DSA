class LCM921MinimumAddToMakeParenthesesValid{
    public int minAddToMakeValid(String S) {
        //Optimal with 2 counters : TC-> O(n) , SC->O(1)
        int cnt = 0;    // cnt = open - close
        int added = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                cnt++;
            }
            else{
                if(cnt>0){
                    cnt--;
                }
                else{
                    added++;
                }
            }
        }
        added = added + cnt;
        return added;

        // Optimal with 3 counters : TC-> O(n) ,SC->O(1)
        // int open = 0,close= 0, added=0;
        // for(int i=0;i<S.length();i++){
        //     char ch = S.charAt(i);
        //     if(ch == '('){
        //         open++;
        //     }
        //     else{
        //         if(open>close){
        //             close++ ;  
        //         }
        //         else{
        //             added++;
        //         }
        //     }
        // }
        // added += (open-close);
        // return added;
        
        // Brute Force : Usig stack : TC->O(n),SC->O(n)
        // Stack<Character> stack = new Stack<>();
        // int c=0;
        // for(int i=0;i<S.length();i++){
        //     char ch = S.charAt(i);
        //     if(ch=='('){
        //         stack.push(ch);
        //     }
        //     else{
        //         if(!stack.isEmpty()){
        //             stack.pop();
        //         }
        //         else{
        //             c++;
        //         }
        //     }
        // }
        // c = c + stack.size();
        // return c;
    }
}