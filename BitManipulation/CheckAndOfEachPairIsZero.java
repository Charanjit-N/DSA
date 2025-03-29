/*Intuition: (Bit Manipulation)
------------
-> a&b will not be zero is there are two set bits(1's) at same position
if given arr = [a,b,c]  let's say we got and(a,b) = 0 , we need to include c and check if a&c;b&c will be 0 or not. We want in which bit positions of either a or b there are 1's and we don't want them in c then both a&c;b&c will become 0, So we do or = a | b (which gives value with 1's when either a or b have 1), So then check whether and c & or is 0 or not, if 0 then every pair in array [a,b,c] has and = 0.
*/

class CheckAndOfEachPairIsZero{
    static boolean check(int[] nums){
        int or = 0;
        for(int i=0;i<nums.length;i++){
            if( (or & nums[i]) != 0) return false;
            or = (or | nums[i]);
        }
        return true;
    }
    public static void main(String args[]){
        int[] nums={3,8,48};
        System.out.println(check(nums));

        int[] nums2={3,8,48,10};
        System.out.println(check(nums2));
    }
}
    