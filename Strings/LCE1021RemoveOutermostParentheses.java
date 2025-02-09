class LCE1021RemoveOutermostParentheses{
    public String removeOuterParentheses(String s) {
        int len = s.length();
        if (len <= 2) return "";
        
        StringBuilder ans = new StringBuilder();
        int open = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                open++;
                if (open > 1) ans.append('(');
            }
            else {
                if (open > 1) ans.append(')');
                open--;
            }
        }
        return ans.toString();


        // Stack<Character> stack = new Stack<>();
        // String ans="";
        // for(int i=0;i<s.length();i++){
        //     if(stack.empty() || stack.peek()==s.charAt(i)){
        //         stack.push(s.charAt(i));
        //         if(stack.size()>1){
        //             ans+=s.charAt(i);
        //         }
        //     }
        //     else if(stack.peek()!=s.charAt(i) && stack.size()!=1 ){
        //         ans+=s.charAt(i);
        //         stack.pop();
        //     }
        //     else{
        //         stack.pop();
        //     }
        // }
        // return ans;
        
    }
}