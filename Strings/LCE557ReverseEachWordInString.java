class LCE557ReverseEachWordInString{
    private void reverse(char[] arr, int left, int right){
        while(left<right){
            char temp = arr[left];
            arr[left++]=arr[right];
            arr[right--]=temp;
        }
    }
    
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        int i=0,j=0;

        while(j<charArr.length){
            if(charArr[j] == ' '){
                reverse(charArr,i,j-1);
                i=j+1;
            }
            j++;
        }
        reverse(charArr,i,j-1);
        return new String(charArr);

        // Aprroach 2
        // int i=0,j=0,len = s.length();
        // StringBuilder sb = new StringBuilder();
        // while(i<len && j<len){
        //     if(s.charAt(j) != ' ') j++;
        //     else{
        //         int k = j-1;
        //         while(k>=i){
        //             sb.append(s.charAt(k));
        //             k--;
        //         }
        //         sb.append(" ");
        //         j++;
        //         i=j;
        //     }
        // }
        // j--;
        // while(j>=i){
        //     sb.append(s.charAt(j));
        //     j--;
        // }
        // return sb.toString();

        
        
    }
}