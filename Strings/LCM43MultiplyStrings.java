// TC -> O(m x n ), SC -> O(m + n) m,n are lengths of input strings
class Solution {
    public String multiply(String num1, String num2) {
        int len1 =  num1.length();
        int len2 = num2.length();
        int[] hash = new int[len1+len2];
        int shift = 0;
        for(int i=len2-1;i>=0;i--){
            int a = num2.charAt(i) - '0';
            int idx = shift ;
            for(int j=len1-1;j>=0;j--){
                int b = num1.charAt(j) - '0';
                int val = a * b;
                hash[idx] += (val%10);
                if(val/10 > 0){
                    hash[idx+1] += val/10;
                }
                idx++;
            }
            shift++;
        }

        for(int i=0;i<hash.length;i++){
            if(hash[i] >= 10){
                hash[i+1] +=  hash[i]/10;
                hash[i] = hash[i]%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i= hash.length-1;i>=0;i--){
            if(!(sb.length() == 0 && hash[i]==0)){
                sb.append((char)('0' + hash[i]));
            }
        }

        return sb.length()==0 ? "0" : sb.toString();
    }
}


 