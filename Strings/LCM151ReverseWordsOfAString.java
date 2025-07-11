class LCM151ReverseWordsOfAString{
    
    public String reverseWords(String s) {
         // TC->O(n) , SC-> O(1) -> String builder is output's space no extra space used

        // Taking string Builder becoz append-> O(1) in case of addition in strings is O(n). Each += concatination in string reate new string object.

        // If we took string instead of string builder here it will be TC->O(n^2) 

        String[] words = s.trim().split(" ");   // Both trim() and split() are O(n)
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){     // O(n)
            if(words[i].length()>0){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        return sb.substring(0,sb.length()-1).toString();  //O(n)



        // Approach 2: 
        // String ans="";
        // int left = 0,right = s.length()-1;
        // while(s.charAt(left)==' ') left++;
        // while(s.charAt(right)==' ') right--;
        
        // int i = right,j = right;
        // while(i>=left && j>=left){
        //     if(s.charAt(j)!=' ') j--;
        //     else{
        //         ans+=s.substring(j+1,i+1);
        //         ans += " ";
        //         while(s.charAt(j)==' ') j--;
        //         System.out.println(i+" "+j);
        //         i=j;
        //         System.out.println(i+" "+j);
                
        //     }
        // }
        // return ans + s.substring(j+1,i+1);


        
    }
}