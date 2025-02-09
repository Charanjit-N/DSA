//Optimal : TC -> O(n), SC->O(1)
class LCM678ValidParenthesisString {
    public boolean checkValidString(String s) {
       int len = s.length();
       int min =0, max =0;
       for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                min = min+1;
                max = max+1;
            }
            else if(ch == ')'){
                min = min-1;
                max= max-1;
            }
            else{
                min = min - 1;
                max = max+1;
            }
            if(min<0) min=0;
            if(max<0) return false;
       }
       return min==0 ? true : false;
    }
}

//Brute Force (TLE): Using Recursion TC-> O(3^n) 
class LCM678ValidParenthesisString {
    public boolean checkValidString(String s) {
       return solve(s,0,0);
    }

    boolean solve(String s, int index, int cnt){
        if(cnt<0) return false;
        if(index == s.length()) return (cnt==0);

        if(s.charAt(index)=='(') return solve(s, index+1, cnt+1);
        if(s.charAt(index)==')') return solve(s, index+1, cnt-1);

        return solve(s, index+1, cnt+1) || solve(s, index+1, cnt-1) || solve(s, index+1, cnt);
    }
}