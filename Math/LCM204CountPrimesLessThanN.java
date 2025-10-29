
// Optimal : Using Sieve of Eratosthenes
// Tc ->O(n log(logn))
class Solution {
    public int countPrimes(int n) {
        int prime[] = new int[n];
        for(int i=2;i<prime.length;i++){
            prime[i] = 1;
        }
        int cnt=0;
        for(int i=2;i*i<n;i++){
            if(prime[i]==1){
                for(int j = i*i;j<n;j+=i){
                    prime[j] = 0;
                }
            }
            
        }
        for(int i =0;i<prime.length;i++){
          if(prime[i]==1) {cnt++;} 
        }
        return cnt;  
    }
}