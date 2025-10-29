
// Optimal : Using Sieve of Eratosthenes
// Tc ->O(n log(logn)) , n = right 
class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] prime = new int[right+1];
        for(int i=2;i<= right;i++) prime[i] = 1;
        for(int i=2;i*i<=right;i++){
            if(prime[i]==1){
                for(int j= i*i ;j<= right;j+=i){
                    prime[j] = 0;
                }
            }
        }

        int prevPrime = -1;
        int num1 = -1, num2 =-1;
        int minDiff = Integer.MAX_VALUE;
        for(int i= left;i<= right;i++){
            if(prime[i]==1){
                if(prevPrime == -1){
                    prevPrime = i ;
                }else{
                    if((i - prevPrime) < minDiff ){
                        minDiff =  i - prevPrime;
                        num1 = prevPrime;
                        num2 = i;
                    }
                    prevPrime = i;
                }
            }
        }
        return new int[]{num1, num2};
        
    }
}