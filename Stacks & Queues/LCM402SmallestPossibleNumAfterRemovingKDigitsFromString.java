class LCM402SmallestPossibleNumAfterRemovingKDigitsFromString {

    public String removeKdigits(String num, int k) {
        /*Optimal : TC->O(3n+k) = O(n+k) (approx)  , SC->O(n)+O(n) {one O(n) is for stack and the other is for returning the ansewer not used for solving the problem}*/
        if(k == num.length()) return "0";
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++){      //TC->O(n)
            char ch = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k>0){    //TC->O(k)
            st.pop();
            k--;
        }
        
        StringBuffer ans  = new StringBuffer();
        boolean gotFirstNonZeroNumber = false;

        //Iterator iterates Stack from bottom to top
        for(Character ele : st){      // TC->O(n)  
            if(ele != '0' && gotFirstNonZeroNumber == false) gotFirstNonZeroNumber = true;
            if(gotFirstNonZeroNumber == true) ans.append(ele); 

        }

        if(gotFirstNonZeroNumber==false) return "0";
        
        return ans.toString();    //TC->O(n)
        
    }
}