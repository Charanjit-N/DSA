/*Intuition: (Bit Manipulation)
------------
-> a&b will not be zero is there are two set bits(1's) at same position
if given arr = [a,b,c]  let's say we got and(a,b) = 0 , we need to include c and check if a&c;b&c will be 0 or not. We want in which bit positions of either a or b there are 1's and we don't want them in c then both a&c;b&c will become 0, So we do or = a | b (which gives value with 1's when either a or b have 1), So then check whether and c & or is 0 or not, if 0 then every pair in array [a,b,c] has and = 0.
*/


// Optimal : sliding Window  TC->O(n), SC->O(1)
class LCM2401LongestSubarrayWithAndOfEachPairIsZero {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int left = 0, right=0;
        int or = 0;
        while(right<n){
            while((nums[right] & or) != 0){
                or = or ^ nums[left];  //(1^1 = 0 :removes the numbers that resulted in bit 1 in 'or' so far form left)
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            or =  (or | nums[right]);
            right++;
        }
        return maxLen;   
    }
}
//Better :  TC->O(n^2)
class LCM2401LongestSubarrayWithAndOfEachPairIsZero {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int or =0;
            for(int j=i;j<n;j++){
                if((nums[j] & or) == 0){
                    maxLen = Math.max(maxLen, j-i+1);
                    or =  (or| nums[j]);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}
// Brute Force : o(n^3)  // Optimizing check to O(n)
class LCM2401LongestSubarrayWithAndOfEachPairIsZero {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(nums, i,j)) maxLen = math.max(maxLen, j-i+1);
                else break;
            }
        }
        return maxLen;   
    }
    boolean check(int[] nums, int a, int b){
        int or = 0;
        for(int i=a;i<=b;i++){
            if( (or & nums[i]) != 0) return false;
            or = (or | nums[i]);
        }
        return true;
    }
}
// Brute Force => O(n^4) : for Each Subarray(o(n^2)) check if every pair and is 0(O(n^2)).