// TC-> O(n), SC->O(n)
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if(len<=numRows || numRows==1) return s;
        int x =  (numRows-2)*2 + 2;
        for(int i=0;i<numRows;i++){
            int j=i;
            if(i==0 || i==numRows-1){
                while(j<len){
                    sb.append(s.charAt(j));
                    j+=x;
                }
            }else{
                int alt = 0;
                while(j<len){
                    sb.append(s.charAt(j));
                    if(alt ==0) j = j + (x-(2*i));
                    else j = j + (2*i);
                    alt = 1 - alt;
                }

            }
           
        }
        return sb.toString();
    }
}