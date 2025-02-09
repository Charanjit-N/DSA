class LCE2696MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {

        // Optimal (Using two pointers) : TC->O(n) , SC->O(n) using extra char array 
        // int i=0;  // write on i
        // int j=1;   // read from j
        // char[] arr = s.toCharArray();
        // int len = arr.length;
        // while(j<len){
        //     if(i<0){
        //         i++;
        //         arr[i] = arr[j];
        //     } 
        //     else if((arr[i]=='A' && arr[j] =='B') ||
        //         (arr[i]=='C' && arr[j] =='D')){
        //         i--;
        //     }
        //     else{
        //         i++;
        //         arr[i] = arr[j];
        //     }

        //     j++;
        // }
        // return i+1;

        // Optimal (Other Approach using String Builder): TC->O(n) , SC->O(n) using string builder
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            if (i > 0 && ((sb.charAt(i) == 'B' && sb.charAt(i - 1) == 'A') || 
                           (sb.charAt(i) == 'D' && sb.charAt(i - 1) == 'C'))) {
                sb.deleteCharAt(i);   
                sb.deleteCharAt(i - 1);
                i = Math.max(0, i - 1); 
            } else {
                i++;
            }
        }
        return sb.length();

        // Better (Using stack) : TC->O(n) , SC->O(n)
        // Stack<Character> st = new Stack<>();
        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(!st.isEmpty() && ((st.peek()=='A' && ch=='B') || (st.peek()=='C' && ch=='D'))){
        //         st.pop();
        //     }
        //     else{
        //         st.push(ch);
        //     }
        // }
        // return st.size();
    }
}