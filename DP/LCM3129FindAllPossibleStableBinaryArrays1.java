// Given COntraints : 1 <= zero, one, limit <= 200

// Recursion : Exponential (TLE)
class Solution {
    int cnt = 0;
    void solve(int zeroCnt, int oneCnt,int zeroStreak, int oneStreak,int limit, int prevVal) {
        if (zeroStreak > limit || oneStreak > limit) return;
        if (zeroCnt == 0 && oneCnt == 0) {
            cnt++;
            return;
        }
        // place 0
        if (zeroCnt > 0) {
            if (prevVal == 0) {
                solve(zeroCnt - 1, oneCnt,
                      zeroStreak + 1, 0,
                      limit, 0);
            } else {
                solve(zeroCnt - 1, oneCnt,
                      1, 0,
                      limit, 0);
            }
        }
        // place 1
        if (oneCnt > 0) {
            if (prevVal == 1) {
                solve(zeroCnt, oneCnt - 1,
                      0, oneStreak + 1,
                      limit, 1);
            } else {
                solve(zeroCnt, oneCnt - 1,
                      0, 1,
                      limit, 1);
            }
        }
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        solve(zero, one, 0, 0, limit, -1);
        return cnt;
    }
}

// Memoization : Time Limit Exceeded ,Memory Limit Exceeded (more dp states)
class Solution {
    int mod =  (int)1e9 + 7;
    Integer[][][][][] dp;
    int solve(int zeroCnt, int oneCnt,int zeroStreak, int oneStreak, int limit, int prevVal) {
        if (zeroStreak > limit || oneStreak > limit) return 0;
        if (zeroCnt == 0 && oneCnt == 0) {
            return 1;
        }
        if(prevVal != -1 && dp[zeroCnt][oneCnt][zeroStreak][oneStreak][prevVal] != null){
            return (int)dp[zeroCnt][oneCnt][zeroStreak][oneStreak][prevVal];
        }
        int a = 0,b=0;
        // put 0
        if (zeroCnt > 0) {
            if (prevVal == 0) {
                a = solve(zeroCnt - 1, oneCnt,zeroStreak + 1, 0,limit, 0);
            } else {
                a = solve(zeroCnt - 1, oneCnt,1, 0,limit, 0);
            }
        }
        // put 1
        if (oneCnt > 0) {
            if (prevVal == 1) {
               b = solve(zeroCnt, oneCnt - 1,0, oneStreak + 1,limit, 1);
            } else {
                b = solve(zeroCnt, oneCnt - 1,0, 1,limit, 1);
            }
        }
        return dp[zeroCnt][oneCnt][zeroStreak][oneStreak][prevVal+1]  = (a + b) % mod;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp  = new Integer[zero+1][one+1][zero+1][one+1][3];   
        solve(zero, one, 0, 0, limit, -1);
        return dp[zero][one][0][0][0];
    }
}

// Memoization : Memory Limit exceeded (more dp states)
class Solution {
    int mod =  (int)1e9 + 7;
    int[][][][] dp;
    int solve(int zeroCnt, int oneCnt,int streak, int limit, int prevVal) {
        if (zeroCnt == 0 && oneCnt == 0) {
            return 1;
        }
        if(dp[zeroCnt][oneCnt][streak][prevVal+1] != -1){
            return dp[zeroCnt][oneCnt][streak][prevVal+1];
        }
        int a = 0,b=0;
        // put 0
        if (zeroCnt > 0) {
            if (prevVal == 0) {
                if(streak + 1 <= limit){
                    a = solve(zeroCnt - 1, oneCnt,streak + 1, limit,0);
                }
            } 
            else {
                a = solve(zeroCnt - 1, oneCnt,1,limit, 0);
            }
        }
        // put 1
        if (oneCnt > 0) {
            if (prevVal == 1) {
                if(streak + 1 <= limit){
                    b = solve(zeroCnt, oneCnt - 1,streak + 1,limit, 1);
                }
            } 
            else {
                b = solve(zeroCnt, oneCnt - 1, 1,limit, 1);
            }
        }
        return dp[zeroCnt][oneCnt][streak][prevVal+1]  = (a + b) % mod;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp  = new int[zero+1][one+1][limit+1][3];
        // initialize dp array with -1
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k <= limit; k++) {
                    for (int l = 0; l < 3; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        solve(zero, one, 0, limit, -1);
        return dp[zero][one][0][0];
    }
}

// Memoization
// TC -->O(zero x one x limit), SC -->O(zero x one x limit)
class Solution {
    int mod = (int)1e9 + 7;
    int[][][] dp0;
    int[][][] dp1;
    int solve0(int zero, int one, int streak, int limit) {
        if (zero == 0 && one == 0) return 1;
        if (dp0[zero][one][streak] != -1){
            return dp0[zero][one][streak];
        }
        int res = 0;
        // can place 0 again
        if (zero > 0 && streak + 1 <= limit) {
            res = (res + solve0(zero - 1, one, streak + 1, limit)) % mod;
        }
        // switch to 1
        if (one > 0) {
            res = (res + solve1(zero, one - 1, 1, limit)) % mod;
        }
        return dp0[zero][one][streak] = res;
    }
    int solve1(int zero, int one, int streak, int limit) {
        if (zero == 0 && one == 0) return 1;
        if (dp1[zero][one][streak] != -1){
            return dp1[zero][one][streak];
        }
        int res = 0;
        // can place 1 again
        if (one > 0 && streak + 1 <= limit) {
            res = (res + solve1(zero, one - 1, streak + 1, limit)) % mod;
        }
        // switch to 0
        if (zero > 0) {
            res = (res + solve0(zero - 1, one, 1, limit)) % mod;
        }
        return dp1[zero][one][streak] = res;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp0 = new int[zero + 1][one + 1][limit + 1];
        dp1 = new int[zero + 1][one + 1][limit + 1];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k <= limit; k++) {
                    dp0[i][j][k] = -1;
                    dp1[i][j][k] = -1;
                }
            }
        }
        int ans = 0;
        // starting with 0
        if (zero > 0){
            ans = (ans + solve0(zero - 1, one, 1, limit)) % mod;
        }
        // starting with 1
        if (one > 0){
            ans = (ans + solve1(zero, one - 1, 1, limit)) % mod;
        }
        return ans;
    }
}