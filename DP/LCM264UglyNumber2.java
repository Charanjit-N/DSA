// optimal sol
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; // first ugly number
        int i2 = 1, i3 = 1, i5 = 1; // pointers for multiples of 2, 3, and 5
        for (int i = 2; i <= n; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;

            int nextUgly = Math.min(next2, Math.min(next3, next5));
            dp[i] = nextUgly;

            if (nextUgly == next2) i2++;
            if (nextUgly == next3) i3++;
            if (nextUgly == next5) i5++;
        }
        return dp[n];
    }
}
// Optimal sol
class Solution {

    public int nthUglyNumber(int n) {
        TreeSet<Long> uglyNumbersSet = new TreeSet<>();
        uglyNumbersSet.add(1L); // Start with 1, the first ugly number
        // TreeSet automatically sorts elements in ascending order and does not
        // allow duplicate entries, just like a HashSet in python

        long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = uglyNumbersSet.pollFirst(); // Get the smallest number from the set and remove it

            // Insert the next potential ugly numbers into the set
            uglyNumbersSet.add(currentUgly * 2);
            uglyNumbersSet.add(currentUgly * 3);
            uglyNumbersSet.add(currentUgly * 5);
        }

        return (int)currentUgly;
    }
}



// Brute Force : TLE
class Solution {
    boolean isUgly(int n) {
        if(n <= 0) return false;
        long num = n;
        
       while(num > 1){
        while(num%2==0){
            num =  num/2;
        }
        while(num%3==0){
            num =  num/3;
            
        }
        while(num%5==0){
            num =  num/5;
        }
        if((num!=1)  && (num %2!=0 ||  num%3!=0 || num%5!=0)) return false;

       }
       return true;
    }
    public int nthUglyNumber(int n) {
        int cnt = 0;
        int i =1;
        while(cnt<=n){
            if(isUgly(i)) cnt++;
            if(cnt == n) break;
            i++;
        }
        return i;
        
    }
}



