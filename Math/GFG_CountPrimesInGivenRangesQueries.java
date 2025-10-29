// Optimal using prefix sum and Sieve of Eratosthenes 
//TC->O(Q +  maxR*log(log maxR) + maxR + Q) =O(Q+maxR*(log(log maxR)) ) = O(maxR * log(log maxR))
class Solution {
    int[] getSieveOfEratosthenesArray(int n) {
        // code here
        int[] prime =  new int[n+1];
        for(int i=2;i<=n;i++) prime[i] =1;
        for(int i=2;i*i<=n;i++){
            if(prime[i] == 1){
                for(int j=i*i ;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }
    List<Integer> processQueries(List<List<Integer>> queries){
        int n = queries.size();
        int maxR = 0;
        for (int i = 0; i < n; i++) {
            maxR = Math.max(maxR, queries.get(i).get(1));
        }
        int[] prime =  getSieveOfEratosthenesArray(maxR);
        for(int i=1;i<=maxR;i++){
            prime[i] =  prime[i]+prime[i-1];
        }
        List<Integer> ans =  new ArrayList<>();
        for(int i = 0;i<n;i++){
            int L = queries.get(i).get(0);
            int R = queries.get(i).get(1);
            int cnt = prime[R] - prime[L-1];
            ans.add(cnt);
        }
        return ans;
    }
}




// Better using Sieve of Eratosthenes 
//TC --> O(Q * R * log(log R))
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
    List<Integer> processQueries(List<List<Integer>> queries){
        int n = queries.size();
        List<Integer> ans =  new ArrayList<>();
        for(int i = 0;i<n;i++){
            int L = queries.get(i).get(0);
            int R = queries.get(i).get(1);
            int cnt = countPrimes(L, R);  
            ans.add(cnt);
        }
        return ans;
    }
}



