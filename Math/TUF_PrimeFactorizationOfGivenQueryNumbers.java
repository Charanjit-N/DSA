// Brute : TC → O(q * sqrt(n))
class Solution {
    public List<List<Integer>> primeFactors(int[] queries) {
        //your code goes here
        List<List<Integer>> ans =  new ArrayList<>();
        for(int x : queries){
            ans.add(PrimeFactorization(x));
        }
        return ans;
    }
    List<Integer> PrimeFactorization(int n){
        List<Integer> pf = new ArrayList<>();
        for(int i=2; i*i <= n; i++){
            if(n % i == 0){
                while(n%i == 0){
                    pf.add(i);
                    n = n/i;
                }
            }
        }
        if(n > 1) pf.add(n);
        return pf;
    }
}


// Optimal :  TC --> O(q + (maxEle*(log(log maxEle))) +  q*log(n) ) = O(q * log(n))
class Solution {
    public static List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> ans =  new ArrayList<>();
        int max = 0;
        for(int x : queries){
            max = Math.max(max, x);
        }

        // SPF Array Pre computation
        int[] spf = new int[max+1];
        for(int i=2; i<=max; i++){
            spf[i] = i;
        }
        for(int i=2; i*i <= max; i++){
            if(spf[i] == i){
                for(int j=i*i ; j<=max; j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
    
        for(int num : queries){
            List<Integer> ls = new ArrayList<>();
            while(num != 1){
                ls.add(spf[num]);
                num = num / spf[num];
                
            }
            ans.add(ls);
        }
        return ans;
    }
}

