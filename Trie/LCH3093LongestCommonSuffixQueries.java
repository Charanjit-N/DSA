

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
    
        int[] ans = new int[wordsQuery.length];
        int idx = 0;

        for(int i=0;i<wordsQuery.length;i++){
            String query = wordsQuery[i]; 
            int LongestSuffixLength = 0;
            int LongSuffixAssociatedWordIndex = -1;
            for(int j=0;j<wordsContainer.length;j++){
                String str =  wordsContainer[j];
                int ptr1=query.length()-1;
                int ptr2 =  str.length()-1;
                while(ptr1>=0 && ptr2>=0 && query.charAt(ptr1)==str.charAt(ptr2)){
                    ptr1--;
                    ptr2--;
                }
                if(query.length()-ptr1 >  LongestSuffixLength){
                    LongSuffixAssociatedWordIndex = j;
                    LongestSuffixLength = query.length()-ptr1;
                }
                else if((query.length()-ptr1) ==  LongestSuffixLength){
                    if(str.length() < wordsContainer[LongSuffixAssociatedWordIndex].length()){
                        LongSuffixAssociatedWordIndex =  j;
                    }
                }
            }
            ans[i] = LongSuffixAssociatedWordIndex;
        }
        return ans;
    }
}