
/* Question : There is a list of consecutive numbers beginning with 1. we want to arrange the numbers in a particular order that satisfies one of the following conditions:

 (i) The number present at the ith position is divisible by i.

 (ii) i is divisible by the number present at the ith position.

Determine how many arrangements of her integers are possible. For example, n = 5 integers, 1,2,3,4,5. Using 1-based indexing, there are the following arrangements that satisfy the conditions:
[1, 2, 3, 4, 5]
[2, 1, 3, 4, 5]
[4, 2, 3, 1, 5]
[5, 2, 3, 4, 1]
[3, 4, 1, 2, 5]
[4, 1, 3, 2, 5]
[2, 4, 3, 1, 5]
[3, 2, 1, 4, 5]
[1, 4, 3, 2, 5]
[5, 4, 3, 2, 1]

answer =  10;
*/

// TC -> O(n!) if no memoization 
// TC -> (n * 2^n) : with memoization 

// Memoization 
class Solution{
    static int solve(int index, int mask , int n,int[][] dp){
        if(mask == ((1<<n)-1)) return 1;  
        //(or) if(index == (n+1)) return 1;

        if(dp[index][mask] != -1) return dp[index][mask];

        int cnt = 0;
        for(int i=1;i<=n;i++){
            if( (((1<<(i-1)) & mask) ==0) && ((index%i==0) || (i%index)==0)){
                cnt += solve(index+1 , (1<<(i-1))|mask , n,dp);
            }
        }
        return dp[index][mask] = cnt;
    }
}