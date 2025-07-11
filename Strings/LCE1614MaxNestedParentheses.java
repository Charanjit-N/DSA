class LCE1614MaxNestedParentheses{
    public int maxDepth(String s) {
       //  TC -> O(n), SC->O(1)
        int count=0,maxCount=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count++;
                maxCount = Math.max(count,maxCount);
            }
            else if(ch == ')'){
                count--;
            }
        }
        return maxCount;
    }
}