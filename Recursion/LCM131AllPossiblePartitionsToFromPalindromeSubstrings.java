class LCM131AllPossiblePartitionsToFromPalindromeSubstrings {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        performPartition(s,0,new ArrayList<>(),res);
        return res;
        
    }
    void performPartition(String s, int index, List<String> ls, List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                ls.add(s.substring(index,i+1));
                performPartition(s,i+1,ls,res);
                ls.remove(ls.size()-1);
            }
        }
       
    }

    boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}