// Brute Force : TC -->O(n^3)
class Solution {
    static long count_triples(int n, int k){
        int i = 0, j = 0, l = 0;
        int count = 0;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                for (l = 1; l <= n; l++) {
                    if ((i + j) % k == 0
                        && (i + l) % k == 0
                        && (j + l) % k == 0)
                        count++;
                }
            }
        }
        return count;
    }
}



//Optimal using Modular Arithmatic : TC-->O(1)
class Solution {
    static long count_triples(int n, int k){
        if (K % 2 == 0) {  // k is even 
            int x = N / K;
            int y = (N + (K / 2)) / K;
            return x * x * x + y * y * y;
        }else {  // k is odd
            int x = N / K;
            return x * x * x;
        }
    }
}

