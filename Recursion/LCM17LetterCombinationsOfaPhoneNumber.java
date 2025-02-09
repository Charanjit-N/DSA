// TC- > O(x^n) n-> (height of the recursion tree)  = length of digits string and x= 4 ( max 4 length string a digit is mapped)
class LCM17LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        findComb(digits, map,0,new StringBuffer(),ans);
        return ans;
        
    }
    void findComb(String digits, Map<Character, String> map,int digitIdx,StringBuffer sb, List<String> ans){
        
        if(digitIdx==digits.length()){
            ans.add(sb.toString());
            return;
        } 

        String req = map.get(digits.charAt(digitIdx));
        for(int i=0;i<req.length();i++){
            sb.append(req.charAt(i));
            findComb(digits,map,digitIdx+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);  
        }
        
    }
}