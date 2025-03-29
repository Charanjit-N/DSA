class LCE20ValidParentheses {
    public boolean isValid(String s) {
       // Optimal : Using Stack   (TC->O(N)  , SC->O(N))
        Map<Character,Character> map = new HashMap<>();    // SC->O(3) contstant doesnt count
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                else if (ch!=map.get(st.peek())) return false;
                else{
                    st.pop();
                }
            }
        }
        if(!st.isEmpty()) return false;
        return true;
        
    }
}