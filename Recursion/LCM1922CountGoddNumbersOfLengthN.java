class LCM1922CountGoddNumbersOfLengthN {

    //using recursion TC->O(logn) , SC->O(logn)
    long modPow(long base, long exp, int mod) {
        if(exp==0) return 1;
        long halfPowerValue = modPow(base, exp/2,mod);
        if(exp%2==1) return (halfPowerValue * halfPowerValue * base) % mod;
        else return (halfPowerValue * halfPowerValue) % mod;
    }

    // TC->O(logn) , SC->O(1)
    // long modPow(long base, long exp, int mod) {
    //     long result = 1;
    //     while (exp > 0) {
    //         if (exp % 2== 1) { 
    //             result = (result * base) % mod;
    //             exp--;
    //         }
    //         else{
    //             exp = exp /2; 
    //             base = (base * base) % mod; 
    //         }
    //     }
    //     return result;
    // }

    public int countGoodNumbers(long n) {
        int modVal = (int)Math.pow(10,9) + 7;
        long evenPlaces = (n+1)/2;
        long oddPlaces = n/2;
        
        long evenPlacePossibilities = modPow(5, evenPlaces, modVal);
        long oddPlacePossibilities = modPow(4, oddPlaces, modVal); 

        long cnt = evenPlacePossibilities * oddPlacePossibilities ;

        return  (int)(cnt % modVal);
        
    }
}