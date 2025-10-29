// using Sieve of Eratosthenes 
//TC --> O(R * log(log R))
class Solution {
    int countPrimes(int L, int R) {
        // code here
        int[] prime =  new int[R+1];
        for(int i=2;i<=R;i++) prime[i] =1;
        for(int i=2;i*i<=R;i++){
            if(prime[i] == 1){
                for(int j=i*i ;j<=R;j+=i){
                    prime[j] = 0;
                }
            }
        }
        
        int cnt =0 ;
        for(int i=L ; i<=R;i++){
            if(prime[i]==1)cnt++;
        }
        return cnt;
        
    }
}

