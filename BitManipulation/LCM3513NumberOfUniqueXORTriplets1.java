/*
For n >= 3 we can obtain all numbers in [0, 2^(msb(n) + 1) - 1], where msb(n) is the index of the most significant bit in n’s binary representation (i.e., the highest power of 2 less than or equal to n). Handle the case when n <= 2 separately.
*/

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n < 3) return n;
       
        int k =1;
        while( k <= n){
            k =  k << 1;
        }
        
       return k;
    }
}


