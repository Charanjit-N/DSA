// Optimal : Binary Search TC -->O(log n)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int low = 0;
        int high = len-1 ;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(letters[mid] > target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (ans == -1) ? letters[0] : letters[ans];
        
    }
}


// TC -->O(n)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int ans = (int)1e9;
        for(int i=0;i<len;i++){
            if(letters[i] > target){
                ans = Math.min(ans,letters[i]);
            }
        }
        return (ans == (int)1e9) ? letters[0] : (char)ans;
    }
}

