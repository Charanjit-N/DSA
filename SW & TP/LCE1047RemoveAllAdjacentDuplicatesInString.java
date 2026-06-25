// Better : Two pointers : TC ->O(n), SC->O(n)
class Solution {
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) 
                i -= 2;
        }
        // System.out.println(Arrays.toString(res));
        return new String(res, 0, i);
    }
}



// Using Stack : TC-->O(n) , SC-->O(n)
class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}